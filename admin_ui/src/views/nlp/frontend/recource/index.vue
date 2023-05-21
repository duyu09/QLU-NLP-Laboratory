<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="链接名称" prop="recourceName">
        <el-input
          v-model="queryParams.recourceName"
          placeholder="请输入链接名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['nlp:frontend:recource:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['nlp:frontend:recource:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['nlp:frontend:recource:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['nlp:frontend:recource:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>
    <el-table v-loading="loading" :data="recourceList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="是否使用" align="center" prop="status" />
      <el-table-column label="链接名称" align="center" prop="recourceName" />
      <el-table-column label="详细内容" align="center" prop="recordContent" >
        <template slot-scope="scope">
          <p v-if="scope.row.recordContent === ''" >请填写详细内容</p>
          <p v-else-if="scope.row.recordContent === null" >请填写详细内容</p>
          <a v-else style="color:#1890ff" @click="openRecordContent(scope.row.recordContent)">点击查看</a>
        </template>
      </el-table-column>
      <el-table-column label="链接地址" align="center" prop="recourceUrl" />
      <el-table-column label="展示顺序" align="center" prop="postSort" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['nlp:frontend:recource:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['nlp:frontend:recource:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改学术资源对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="80%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="链接名称" prop="recourceName">
          <el-input v-model="form.recourceName" placeholder="请输入链接名称" />
        </el-form-item>
        <el-form-item label="详细内容">
          <MarkdownEditor v-model="form.recordContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="链接地址" prop="recourceUrl">
          <el-input v-model="form.recourceUrl" placeholder="请输入链接地址" />
        </el-form-item>
        <el-form-item label="展示顺序" prop="postSort">
          <el-input-number v-model="form.postSort" controls-position="right" :min="1" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <!--    详细内容预览框-->
    <el-dialog title="详解内容" :visible.sync="ifShowRecordContent" @close="closeRecordContent">
      <v-md-preview :text="showRecordContent"></v-md-preview>
    </el-dialog>
  </div>
</template>

<script>
import { listRecource, getRecource, delRecource, addRecource, updateRecource } from "@/api/nlp/frontend/recource";

export default {
  name: "Recource",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 学术资源表格数据
      recourceList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 详细介绍是否展示
      ifShowRecordContent: false,
      //详细介绍内容
      showRecordContent: '',
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        status: null,
        recourceName: null,
        recordContent: null,
        recourceUrl: null,
        postSort: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        recourceName: [
          { required: true, message: "请输入链接名称", trigger: "blur" }
        ],
        recordContent: [
          { required: true, message: "请输入详细内容", trigger: "blur" }
        ],
        status: [
          { required: true, message: "状态不能为空", trigger: "change" }
        ],
        postSort: [
          { required: true, message: "顺序不能空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询学术资源列表 */
    getList() {
      this.loading = true;
      listRecource(this.queryParams).then(response => {
        this.recourceList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        status: "0",
        recourceName: null,
        recordContent: '',
        recourceUrl: null,
        postSort: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加学术资源";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getRecource(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学术资源";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateRecource(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRecource(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除学术资源编号为"' + ids + '"的数据项？').then(function() {
        return delRecource(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('nlp/frontend/recource/export', {
        ...this.queryParams
      }, `recource_${new Date().getTime()}.xlsx`)
    },
    // 详情展示 打开
    openRecordContent(data) {
      this.ifShowRecordContent = true;
      this.showRecordContent = data;
    },
    // 详情展示 关闭
    closeRecordContent() {
      this.showRecordContent = '';
    },
  }
};
</script>
