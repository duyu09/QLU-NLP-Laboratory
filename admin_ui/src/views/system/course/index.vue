<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="title标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入title标题"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="视频的bilibili链接" prop="videoLink">
        <el-input
          v-model="queryParams.videoLink"
          placeholder="请输入视频的bilibili链接"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程PDF的下载url" prop="downPdfLink">
        <el-input
          v-model="queryParams.downPdfLink"
          placeholder="请输入课程PDF的下载url"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程视频的下载url" prop="downVideoLink">
        <el-input
          v-model="queryParams.downVideoLink"
          placeholder="请输入课程视频的下载url"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="类别id 用来连表查询" prop="charaClassId">
        <el-input
          v-model="queryParams.charaClassId"
          placeholder="请输入类别id 用来连表查询"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="逻辑删除，0=正常，1=删除" prop="deleted">
        <el-input
          v-model="queryParams.deleted"
          placeholder="请输入逻辑删除，0=正常，1=删除"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="控制展示顺序" prop="sequence">
        <el-input
          v-model="queryParams.sequence"
          placeholder="请输入控制展示顺序"
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
          v-hasPermi="['system:course:add']"
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
          v-hasPermi="['system:course:edit']"
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
          v-hasPermi="['system:course:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:course:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="courseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="视频主键" align="center" prop="id" />
      <el-table-column label="名称" align="center" prop="name" />
      <el-table-column label="title标题" align="center" prop="title" />
      <el-table-column label="视频的bilibili链接" align="center" prop="videoLink" />
      <el-table-column label="markdown展示内容" align="center" prop="recordContent" />
      <el-table-column label="课程PDF的下载url" align="center" prop="downPdfLink" />
      <el-table-column label="课程视频的下载url" align="center" prop="downVideoLink" />
      <el-table-column label="类别id 用来连表查询" align="center" prop="charaClassId" />
      <el-table-column label="逻辑删除，0=正常，1=删除" align="center" prop="deleted" />
      <el-table-column label="控制展示顺序" align="center" prop="sequence" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:course:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:course:remove']"
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

    <!-- 添加或修改视频资源数据对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入名称" />
        </el-form-item>
        <el-form-item label="title标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入title标题" />
        </el-form-item>
        <el-form-item label="视频的bilibili链接" prop="videoLink">
          <el-input v-model="form.videoLink" placeholder="请输入视频的bilibili链接" />
        </el-form-item>
        <el-form-item label="markdown展示内容">
          <editor v-model="form.recordContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="课程PDF的下载url" prop="downPdfLink">
          <el-input v-model="form.downPdfLink" placeholder="请输入课程PDF的下载url" />
        </el-form-item>
        <el-form-item label="课程视频的下载url" prop="downVideoLink">
          <el-input v-model="form.downVideoLink" placeholder="请输入课程视频的下载url" />
        </el-form-item>
        <el-form-item label="类别id 用来连表查询" prop="charaClassId">
          <el-input v-model="form.charaClassId" placeholder="请输入类别id 用来连表查询" />
        </el-form-item>
        <el-form-item label="逻辑删除，0=正常，1=删除" prop="deleted">
          <el-input v-model="form.deleted" placeholder="请输入逻辑删除，0=正常，1=删除" />
        </el-form-item>
        <el-form-item label="控制展示顺序" prop="sequence">
          <el-input v-model="form.sequence" placeholder="请输入控制展示顺序" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCourse, getCourse, delCourse, addCourse, updateCourse } from "@/api/system/course";

export default {
  name: "Course",
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
      // 视频资源数据表格数据
      courseList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        title: null,
        videoLink: null,
        recordContent: null,
        downPdfLink: null,
        downVideoLink: null,
        charaClassId: null,
        deleted: null,
        sequence: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        charaClassId: [
          { required: true, message: "类别id 用来连表查询不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询视频资源数据列表 */
    getList() {
      this.loading = true;
      listCourse(this.queryParams).then(response => {
        this.courseList = response.rows;
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
        title: null,
        videoLink: null,
        recordContent: null,
        downPdfLink: null,
        downVideoLink: null,
        charaClassId: null,
        deleted: null,
        sequence: null
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
      this.title = "添加视频资源数据";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCourse(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改视频资源数据";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCourse(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCourse(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除视频资源数据编号为"' + ids + '"的数据项？').then(function() {
        return delCourse(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/course/export', {
        ...this.queryParams
      }, `course_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
