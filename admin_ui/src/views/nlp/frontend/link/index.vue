<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="是否使用" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择是否使用" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_normal_disable"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="链接名称" prop="linkName">
        <el-input
          v-model="queryParams.linkName"
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
          v-hasPermi="['nlp:frontend:link:add']"
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
          v-hasPermi="['nlp:frontend:link:edit']"
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
          v-hasPermi="['nlp:frontend:link:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['nlp:frontend:link:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="frontendLinkList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="展示顺序" align="center" prop="postSort" />
      <el-table-column label="链接名称" align="center" prop="linkName" />
      <el-table-column label="链接地址" align="center" prop="linkUrl" >
<!--        <template slot-scope="scope">-->
<!--          <p v-if="scope.row.linkUrl === ''" >请填写链接地址</p>-->
<!--          <p v-else-if="scope.row.linkUrl === null" >请填写链接地址</p>-->
<!--          <a v-else style="color:#1890ff" @click="openLinkUrl(scope.row.linkUrl)">点击查看</a>-->
<!--        </template>-->
      </el-table-column>
      <el-table-column label="是否使用" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_normal_disable" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['nlp:frontend:link:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['nlp:frontend:link:remove']"
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

    <!-- 添加或修改友情链接对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="60%"  append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="温馨提示">
          <div>
            <el-tag type="danger" size="large" >链接地址需要写全，格式为：http://.../</el-tag>
          </div>
        </el-form-item>
        <el-form-item label="是否使用">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_normal_disable"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="链接名称" prop="linkName">
          <el-input v-model="form.linkName" placeholder="请输入链接名称" />
        </el-form-item>
        <el-form-item label="链接地址" prop="linkUrl">
          <el-input v-model="form.linkUrl" placeholder="请输入链接地址" />
        </el-form-item>
<!--        <el-form-item label="展示顺序" prop="postSort">-->
<!--          <el-input v-model="form.postSort" placeholder="请输入展示顺序" />-->
<!--        </el-form-item>-->
        <el-form-item label="排序" prop="postSort">
          <el-input-number v-model="form.postSort" controls-position="right" :min="0" />
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

<!--    &lt;!&ndash;    友链预览框&ndash;&gt;-->
<!--    <el-dialog title="友链地址" :visible.sync="ifShowLinkUrl" @close="closeLinkUrl">-->
<!--      <v-md-preview :text="showLinkUrl"></v-md-preview>-->
<!--    </el-dialog>-->
  </div>
</template>

<script>
import { listFrontendLink, getFrontendLink, delFrontendLink, addFrontendLink, updateFrontendLink } from "@/api/nlp/frontend/link";

export default {
  name: "FrontendLink",
  dicts: ['sys_normal_disable'],
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
      // 友情链接表格数据
      frontendLinkList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 详细介绍是否展示
      ifShowLinkUrl: false,
      //详细介绍内容
      showLinkUrl: '',
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        status: null,
        linkName: null,
        linkUrl: null,
        postSort: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {

        linkName: [
          { required: true, message: "请输入友链名称", trigger: "blur" }
        ],
        linkUrl: [
          { required: true, message: "友链地址不能为空", trigger: "blur" }
        ],
        postSort: [
          { required: true, message: "显示顺序不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询友情链接列表 */
    getList() {
      this.loading = true;
      listFrontendLink(this.queryParams).then(response => {
        this.frontendLinkList = response.rows;
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
        linkName: null,
        linkUrl: null,
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
      this.title = "添加友情链接";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getFrontendLink(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改友情链接";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateFrontendLink(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addFrontendLink(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除').then(function() {
        return delFrontendLink(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('nlp/frontend/link/export', {
        ...this.queryParams
      }, `frontendLink_${new Date().getTime()}.xlsx`)
    },
    // 详情展示 打开
    openLinkUrl(data) {
      this.ifShowLinkUrl = true;
      this.showLinkUrl = data;
    },
    // 详情展示 关闭
    closeLinkUrl() {
      this.showLinkUrl = '';
    },
  }
};
</script>
