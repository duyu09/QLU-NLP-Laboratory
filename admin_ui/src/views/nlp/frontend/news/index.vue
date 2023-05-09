<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">

      <el-form-item label="标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入title标题"
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
          v-hasPermi="['nlp:frontend:news:add']"
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
          v-hasPermi="['nlp:frontend:news:edit']"
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
          v-hasPermi="['nlp:frontend:news:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['nlp:frontend:news:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="nlpFrontendNewsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="新闻插图" align="center" prop="newsImg" >
        <template slot-scope="scope">
          <div style="width: 100px; height: 100px">
            <el-image
              :src="showImgUrl + scope.row.newsImg"
              fix="contain"
              :preview-src-list="showImgUrlBox"
              @click="addShowImgUrl(showImgUrl + scope.row.newsImg)"
            />
          </div>
        </template>
      </el-table-column>
      <el-table-column label="标题" align="center" prop="title" />
      <el-table-column label="是否置顶" align="center" prop="isStick">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.nlp_isFrame_yes_no" :value="scope.row.isStick"/>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_normal_disable" :value="scope.row.status"/>
        </template>
      </el-table-column>

      <el-table-column label="简介内容" align="center" prop="synopsisContent" />

      <el-table-column label="详细内容" align="center" prop="recordContent" >
        <template slot-scope="scope">
          <p v-if="scope.row.recordContent === ''" >请填写详细内容</p>
          <p v-else-if="scope.row.recordContent === null" >请填写详细内容</p>
          <a v-else style="color:#1890ff" @click="openRecordContent(scope.row.recordContent)">点击查看</a>
        </template>
      </el-table-column>

      <el-table-column label="展示顺序" align="center" prop="postSort" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['nlp:frontend:news:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['nlp:frontend:news:remove']"
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

    <!-- 添加或修改新闻动态管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="80%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="新闻插图" prop="newsImg">
          <imageUpload v-model="form.newsImg":limit="1"/>
        </el-form-item>
        <el-form-item label="标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入title标题" />
        </el-form-item>
<!--        <el-form-item label="简介内容">-->
<!--          <MarkdownEditor v-model="form.synopsisContent" :min-height="192"/>-->
<!--        </el-form-item>-->
        <el-form-item label="简介内容">
<!--          <editor v-model="form.synopsisContent" :min-height="192"/>-->
          <el-input v-model="form.synopsisContent" type="textarea" placeholder="请输入简介内容" />
        </el-form-item>
        <el-form-item label="详细内容">
          <MarkdownEditor v-model="form.recordContent" :min-height="192"/>
        </el-form-item>

        <el-form-item label="是否置顶" prop="isStick">
          <el-radio-group v-model="form.isStick">
            <el-radio
              v-for="dict in dict.type.nlp_isFrame_yes_no"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="展示顺序" prop="postSort">
          <el-input-number v-model="form.postSort" controls-position="right" :min="1" />
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
    </el-dialog>

    <!--    详细内容预览框-->
    <el-dialog title="详解内容" :visible.sync="ifShowRecordContent" @close="closeRecordContent">
      <v-md-preview :text="showRecordContent"></v-md-preview>
    </el-dialog>
    <!--    简介内容预览框-->
    <el-dialog title="简介内容" :visible.sync="ifShowSynopsisContent" @close="closeSynopsisContent">
      <v-md-preview :text="showSynopsisContent"></v-md-preview>
    </el-dialog>
  </div>
</template>

<script>
import { listNlpFrontendNews, getNlpFrontendNews, delNlpFrontendNews, addNlpFrontendNews, updateNlpFrontendNews } from "@/api/nlp/frontend/news";

export default {
  name: "NlpFrontendNews",
  dicts: ['nlp_isFrame_yes_no','sys_normal_disable'],
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
      // 新闻动态管理表格数据
      nlpFrontendNewsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 详细介绍是否展示
      ifShowRecordContent: false,
      //详细介绍内容
      showRecordContent: '',
      //简介内容是否展示
      ifShowSynopsisContent: false,
      //简介介绍内容
      showSynopsisContent: '',
      // 预览大图功能数组
      showImgUrlBox: [],
      // 图片显示路径
      showImgUrl: process.env.VUE_APP_BASE_API,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        newsImg: null,
        title: null,
        synopsisContent: null,
        recordContent: null,
        isStick: null,
        postSort: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        title: [
          { required: true, message: "请输入标题", trigger: "blur" }
        ],
        synopsisContent: [
          { required: true, message: "请输入简介内容", trigger: "blur" }
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
    /** 查询新闻动态管理列表 */
    getList() {
      this.loading = true;
      listNlpFrontendNews(this.queryParams).then(response => {
        this.nlpFrontendNewsList = response.rows;
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
        newsImg: null,
        title: null,
        synopsisContent: '',
        recordContent: '',
        isStick: "1",
        postSort: "0",
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
      this.title = "添加新闻动态管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getNlpFrontendNews(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改新闻动态管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateNlpFrontendNews(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addNlpFrontendNews(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除新闻动态管理编号为"' + ids + '"的数据项？').then(function () {
        return delNlpFrontendNews(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('nlp/frontend/news/export', {
        ...this.queryParams
      }, `nlpFrontendNews_${new Date().getTime()}.xlsx`)
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

    // 简介展示 打开
    openSynopsisContent(data) {
      this.ifShowSynopsisContent = true;
      this.showSynopsisContent = data;
    },
    // 简介展示 关闭
    closeSynopsisContent() {
      this.showSynopsisContent = '';
    },
    /** 点击图片预览功能 */
    addShowImgUrl(data) {
      this.showImgUrlBox.push(data)
    },
  }
};
</script>
