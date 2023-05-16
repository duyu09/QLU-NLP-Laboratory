<template>
  <div class="app-container">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="名字" prop="name">
          <el-input v-model="form.name" placeholder="请输入名字" />
        </el-form-item>
        <el-form-item label="详细内容">
          <MarkdownEditor v-model="form.recordContent"></MarkdownEditor>
        </el-form-item>
        <el-form-item label="详情类型" prop="type">
          <el-input v-model="form.type" placeholder="请输入类型"/>
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_normal_disable"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    <!--    详细内容预览框-->
    <el-dialog title="详情内容" :visible.sync="ifShowRecordContent" @close="closeRecordContent">
      <v-md-preview :text="showRecordContent"></v-md-preview>
    </el-dialog>
  </div>
</template>

<script>
import { listFrontendAbout, getFrontendAbout, delFrontendAbout, addFrontendAbout, updateFrontendAbout, getByType} from "@/api/nlp/frontend/about";

export default {
  name: "FrontendAbout",
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
      // 联系我们表格数据
      frontendAboutList: [],
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
  // 查一下这个 created 这个能理解为进入这个页面之后默认执行的 可以是去调用js方法
  created() {
    this.getInfoByType(this.$route.query.type);
  },
  // 查一下这个 methods  这里是写js方法的
  methods: {
    /** 查询联系我们列表 */
    getList() {
      this.loading = true;
      listFrontendAbout(this.queryParams).then(response => {
        this.frontendAboutList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询联系我们列表 */
    getInfoByType(type) {
      this.loading = true;
      getByType(type).then(response => {
        this.form = response.data;
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
      this.title = "添加联系我们";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getFrontendAbout(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改联系我们";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateFrontendAbout(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addFrontendAbout(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除联系我们编号为"' + ids + '"的数据项？').then(function() {
        return delFrontendAbout(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('nlp/frontend/about/export', {
        ...this.queryParams
      }, `frontendAbout_${new Date().getTime()}.xlsx`)
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
