<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="轮播图名称" prop="carouselName">
        <el-input
          v-model="queryParams.carouselName"
          placeholder="请输入轮播图名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="轮播图状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择轮播图状态" clearable size="small">
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
          v-hasPermi="['nlp:frontend:carousel:add']"
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
          v-hasPermi="['nlp:frontend:carousel:edit']"
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
          v-hasPermi="['nlp:frontend:carousel:remove']"
        >删除</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="carouselList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" type="index" align="center">
        <template slot-scope="scope">
          <span>{{(queryParams.pageNum - 1) * queryParams.pageSize + scope.$index + 1}}</span>
        </template>
      </el-table-column>
      <el-table-column label="轮播图" align="center" prop="carouselImg" >
        <template slot-scope="scope">
          <div style="width: 100px; height: 100px">
            <el-image
              :src="showImgUrl + scope.row.carouselImg"
              fix="contain"
              :preview-src-list="showImgUrlBox"
              @click="addShowImgUrl(showImgUrl + scope.row.carouselImg)"
            />
          </div>
        </template>
      </el-table-column>
      <el-table-column label="轮播图名称" align="center" prop="carouselName" width="110px"/>
      <el-table-column label="是否为外链 " align="center" prop="isFrame" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.nlp_isFrame_yes_no" :value="scope.row.isFrame"/>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_normal_disable" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="详细信息" align="center" prop="recordContent" >
        <template slot-scope="scope">
          <div v-if="scope.row.isFrame === '0'">
            <a style="color:#1890ff" @click="openFrame(scope.row.urlPath)"><u>{{scope.row.urlPath}}</u></a>
          </div>
          <div v-else>
            <p v-if="scope.row.recordContent === '' || scope.row.recordContent === null" >请填写详细内容</p>
            <a v-else style="color:#1890ff" @click="openRecordContent(scope.row.recordContent)">点击查看</a>
          </div>
        </template>
      </el-table-column>

      <el-table-column label="轮播图顺序" align="center" prop="postSort" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['nlp:frontend:carousel:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['nlp:frontend:carousel:remove']"
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

    <!-- 添加或修改轮播图对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="80%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="轮播图">
          <imageUpload v-model="form.carouselImg" :limit="1"/>
        </el-form-item>
        <el-form-item label="轮播图名称" prop="carouselName">
          <el-input v-model="form.carouselName" placeholder="请输入轮播图名称" />
        </el-form-item>
        <el-form-item label="是否为外链" prop="isFrame">
          <el-radio-group v-model="form.isFrame">
            <el-radio
            v-for="dict in dict.type.nlp_isFrame_yes_no"
            :key="dict.value"
            :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <div v-if="form.isFrame == 0">
        <el-form-item  label="路由地址" prop="urlPath">
          <el-input v-model="form.urlPath" placeholder="请输入路由地址" />
        </el-form-item>
        </div>
        <div v-if="form.isFrame == 1">
        <el-form-item  label="详细信息">
          <MarkdownEditor v-model="form.recordContent"></MarkdownEditor>
        </el-form-item>
        </div>
        <el-form-item label="轮播图排序" prop="postSort">
          <el-input-number v-model="form.postSort" controls-position="right" :min="0" />
        </el-form-item>
        <el-form-item label="轮播图状态">
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
    <el-dialog title="轮播图内容" :visible.sync="ifShowRecordContent" @close="closeRecordContent">
      <v-md-preview :text="showRecordContent"></v-md-preview>
    </el-dialog>

  </div>
</template>

<script>
import { listCarousel, getCarousel, delCarousel, addCarousel, updateCarousel } from "@/api/nlp/frontend/carousel";

export default {
  name: "Carousel",
  dicts: ['nlp_isFrame_yes_no','sys_normal_disable'],
  data() {
    return {
      radio: 0,
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
      // 轮播图表格数据
      carouselList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 图片显示路径
      showImgUrl: process.env.VUE_APP_BASE_API,
      // 详细介绍是否展示
      ifShowRecordContent: false,
      //详细介绍内容
      showRecordContent: '',
      // 预览大图功能数组
      showImgUrlBox: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        carouselName: null,
        isFrame: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {

        carouselName: [
          { required: true, message: "请输入轮播图名称", trigger: "blur" }
        ],
        isFrame: [
          { required: true, message: "是否外链不能为空", trigger: "change" }
        ],
        postSort: [
          { required: true, message: "显示顺序不能为空", trigger: "change" }
        ],
        status: [
          { required: true, message: "状态不能为空", trigger: "change" }
        ],
        carouselImg: [
          { required: true, message: "请插入轮播图", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询轮播图列表 */
    getList() {
      this.loading = true;
      listCarousel(this.queryParams).then(response => {
        this.carouselList = response.rows;
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
        carouselImg: null,
        carouselName: null,
        urlPath: null,
        recordContent: '',
        postSort: null,
        isFrame:"0",
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
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加轮播图";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCarousel(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改轮播图";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCarousel(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCarousel(this.form).then(response => {
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
        return delCarousel(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('nlp/frontend/carousel/export', {
        ...this.queryParams
      }, `carousel_${new Date().getTime()}.xlsx`)
    },
    // 页面跳转 打开
    openFrame(data) {
      window.open("http://"+data);
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
    /** 点击图片预览功能 */
    addShowImgUrl(data) {
      this.showImgUrlBox.push(data)
    },
  }
};
</script>
