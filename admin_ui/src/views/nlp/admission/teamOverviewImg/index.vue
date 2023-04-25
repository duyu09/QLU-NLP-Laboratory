<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="图片名称" prop="imgName">
        <el-input
          v-model="queryParams.imgName"
          placeholder="请输入图片名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['nlp:admission:teamOverviewImg:add']"
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
          v-hasPermi="['nlp:admission:teamOverviewImg:edit']"
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
          v-hasPermi="['nlp:admission:teamOverviewImg:remove']"
        >删除</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="teamOverviewImgList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="图片" align="center" prop="imgUrl" >
        <template slot-scope="scope">
          <div style="width: 100px; height: 100px">
            <el-image
              :src="showImgUrl + scope.row.imgUrl"
              fix="contain"
              :preview-src-list="showImgUrlBox"
              @click="addShowImgUrl(showImgUrl + scope.row.imgUrl)"
            />
          </div>
        </template>
      </el-table-column>
      <el-table-column label="图片名称" align="center" prop="imgName" />
      <el-table-column label="显示顺序" align="center" prop="postSort" />
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_normal_disable" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['nlp:admission:teamOverviewImg:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['nlp:admission:teamOverviewImg:remove']"
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

    <!-- 添加或修改团队掠影 图片 (img)对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="图片上传">
          <imageUpload v-model="form.imgUrl" :limit="1"/>
        </el-form-item>
        <el-form-item label="图片名称" prop="imgName">
          <el-input v-model="form.imgName" placeholder="请输入图片名称" />
        </el-form-item>
        <el-form-item label="显示顺序" prop="postSort">
          <el-input-number v-model="form.postSort" controls-position="right" :min="0" />
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
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listTeamOverviewImg, getTeamOverviewImg, delTeamOverviewImg, addTeamOverviewImg, updateTeamOverviewImg } from "@/api/nlp/admission/teamOverviewImg";
import {teamOverview} from "@/store/teamOverview";

export default {
  name: "TeamOverviewImg",
  inject: ['reload'],
  components: {},
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
      // 团队掠影 图片 (img)表格数据
      teamOverviewImgList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 图片显示路径
      showImgUrl: process.env.VUE_APP_BASE_API,
      // 预览大图功能数组
      showImgUrlBox: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        titleId: teamOverview.titleId,
        imgName: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        titleId: [
          { required: true, message: "掠影分类标题id不能为空", trigger: "blur" }
        ],
        postSort: [
          { required: true, message: "显示顺序不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "状态不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询团队掠影 图片 (img)列表 */
    getList() {
      this.queryParams.titleId = teamOverview.titleId;
      this.loading = true;
      listTeamOverviewImg(this.queryParams).then(response => {
        this.teamOverviewImgList = response.rows;
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
        titleId: null,
        imgUrl: null,
        imgName: null,
        postSort: null,
        status: "0",
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
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
      this.title = "添加 新掠影图片";
      this.form.titleId = teamOverview.titleId;
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTeamOverviewImg(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改 " + this.form.imgName;
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateTeamOverviewImg(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTeamOverviewImg(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除团队掠影 图片 编号为"' + ids + '"的数据项？').then(function() {
        return delTeamOverviewImg(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('/nlp/admission/teamOverviewImg/export', {
        ...this.queryParams
      }, `teamOverviewImg_${new Date().getTime()}.xlsx`)
    },
    /** 点击图片预览功能 */
    addShowImgUrl(data) {
      this.showImgUrlBox.push(data)
    },
  }
};
</script>
