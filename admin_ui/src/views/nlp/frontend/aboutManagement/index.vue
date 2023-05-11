<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="名字" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入名字"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="详情类型" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择详情类型" clearable size="small">
          <el-option
            v-for="dict in dict.type.nlp_frontend_markdown"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_normal_disable"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
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
          v-hasPermi="['nlp:frontend:aboutManagement:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['nlp:frontend:aboutManagement:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['nlp:frontend:aboutManagement:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['nlp:frontend:aboutManagement:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="frontendAboutManagementList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="名字" align="center" prop="name"/>
      <el-table-column label="展示顺序" align="center" prop="postSort"/>
      <el-table-column label="详细内容" align="center" prop="recordContent">
        <template slot-scope="scope">
          <p v-if="scope.row.recordContent === ''">请填写详细内容</p>
          <p v-else-if="scope.row.recordContent === null">请填写详细内容</p>
          <a v-else style="color:#1890ff" @click="openRecordContent(scope.row.recordContent)">点击查看</a>
        </template>
      </el-table-column>
      <!--      <el-table-column label="详情类型" align="center" prop="type">-->
      <!--        <template slot-scope="scope">-->
      <!--          <dict-tag :options="dict.type.nlp_frontend_markdown" :value="scope.row.type"/>-->
      <!--        </template>-->
      <!--      </el-table-column>-->
      <el-table-column label="详情类型" align="center" prop="type"/>

      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_normal_disable" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['nlp:frontend:aboutManagement:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['nlp:frontend:aboutManagement:remove']"
          >删除
          </el-button>
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

    <!-- 添加或修改联系我们(管理)对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="80%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="名字" prop="name">
          <el-input v-model="form.name" placeholder="请输入名字"/>
        </el-form-item>
        <el-form-item label="展示顺序" prop="postSort">
          <el-input-number v-model="form.postSort" controls-position="right" :min="0"/>
        </el-form-item>
        <el-form-item label="详细内容">
          <!--          <editor v-model="form.recordContent" :min-height="192"/>-->
          <MarkdownEditor v-model="form.recordContent"></MarkdownEditor>
        </el-form-item>
        <el-form-item label="详情类型" prop="type">
          <!--          <el-select v-model="form.type" placeholder="请选择详情类型">-->
          <!--            <el-option-->
          <!--              v-for="dict in dict.type.nlp_frontend_markdown"-->
          <!--              :key="dict.value"-->
          <!--              :label="dict.label"-->
          <!--              :value="dict.value"-->
          <!--            ></el-option>-->
          <!--          </el-select>-->

          <el-input v-model="form.type" placeholder="请输入类型"/>
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_normal_disable"
              :key="dict.value"
              :label="dict.value"
            >{{ dict.label }}
            </el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!--    详细内容预览框-->
    <el-dialog title="详情内容" :visible.sync="ifShowRecordContent" @close="closeRecordContent">
      <v-md-preview :text="showRecordContent"></v-md-preview>
    </el-dialog>
  </div>
</template>

<script>
import { listFrontendAboutManagement, getFrontendAboutManagement, delFrontendAboutManagement, addFrontendAboutManagement, updateFrontendAboutManagement } from "@/api/nlp/frontend/aboutManagement";

export default {
  name: "FrontendAboutManagement",
  dicts: ['nlp_frontend_markdown', 'sys_normal_disable'],
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
      // 联系我们(管理)表格数据
      frontendAboutManagementList: [],
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
        name: null,
        postSort: null,
        recordContent: null,
        type: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        name: [
          {required: true, message: "请输入名字", trigger: "blur"}
        ],
        type: [
          {required: true, message: "所属类别不能为空", trigger: "blur"},
        ],
        postSort: [
          {required: true, message: "显示顺序不能为空", trigger: "blur"}
        ],
        status: [
          {required: true, message: "状态不能为空", trigger: "blur"}
        ],

      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询联系我们(管理)列表 */
    getList() {
      this.loading = true;
      listFrontendAboutManagement(this.queryParams).then(response => {
        this.frontendAboutManagementList = response.rows;
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
        name: null,
        postSort: null,
        recordContent: '',
        type: null,
        status: "0",
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
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加联系我们(管理)";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getFrontendAboutManagement(id).then(response => {
        this.behaviourCode = response.behaviourCode;
        this.form = response.data;
        this.open = true;
        this.title = "修改联系我们(管理)";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateFrontendAboutManagement(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addFrontendAboutManagement(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除').then(function () {
        return delFrontendAboutManagement(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('nlp/frontend/aboutManagement/export', {
        ...this.queryParams
      }, `frontendAboutManagement_${new Date().getTime()}.xlsx`)
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
