<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="掠影分类标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入掠影分类标题"
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
          v-hasPermi="['nlp:admission:teamOverviewTitle:add']"
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
          v-hasPermi="['nlp:admission:teamOverviewTitle:edit']"
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
          v-hasPermi="['nlp:admission:teamOverviewTitle:remove']"
        >删除</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getListTitle"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="teamOverviewTitleList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="Id" align="center" prop="id" />
      <el-table-column label="掠影分类标题" align="center" prop="title" id="twinkling"/>
      <el-table-column label="显示顺序" align="center" prop="postSort" />
      <el-table-column label="状态" align="center" prop="status">
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
            v-hasPermi="['nlp:admission:teamOverviewTitle:edit']"
          >管理掠影</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['nlp:admission:teamOverviewTitle:remove']"
            class="twinkling"
          >删除分类</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getListTitle"
    />

    <!-- 新增团队掠影 标题 (title)对话框 -->
    <el-dialog :title="title" :visible.sync="openAdd" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px" :inline="true">
        <el-form-item label="掠影分类标题" prop="title" >
          <el-input v-model="form.title" placeholder="请输入掠影分类标题" />
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
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 修改团队掠影 标题 (title)对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="80%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px" :inline="true">
        <el-form-item label="掠影分类标题" prop="title" >
          <el-input v-model="form.title" placeholder="请输入掠影分类标题" />
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
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>

      <el-divider />

      <!-- TeamOverviewImg.index.vue -->
      <TeamOverviewImg/>
    </el-dialog>

  </div>
</template>

<script>
import { listTeamOverviewTitle, getTeamOverviewTitle, delTeamOverviewTitle, addTeamOverviewTitle, updateTeamOverviewTitle } from "@/api/nlp/admission/teamOverviewTitle";
import { listTeamOverviewImg } from "@/api/nlp/admission/teamOverviewImg";
import TeamOverviewImg from "@/views/nlp/admission/teamOverviewImg/index.vue";
import {teamOverview} from "@/store/teamOverview";

export default {
  name: "TeamOverviewTitle",
  inject: ['reload'],
  components: {TeamOverviewImg},
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
      totalImg: 0,
      // 团队掠影 标题 (title)表格数据
      teamOverviewTitleList: [],
      // 团队掠影 图片 (img)表格数据
      teamOverviewImgList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      openAdd: false,
      // 每行掠影分类标题里是否有图片
      hasImg: null,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        title: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
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
    // 查询团队掠影 标题 (title)列表
    this.getListTitle();
    // 点击修改后 刷新页面 -> teamOverview.auto = true -> 打开弹出层
    this.autoOpenUpdatePage();
  },
  methods: {

      /** ----- title 操作 ----- */

    /** 查询团队掠影 标题 (title)列表 */
    getListTitle() {
      this.loading = true;
      listTeamOverviewTitle(this.queryParams).then(response => {
        this.teamOverviewTitleList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.openAdd = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        title: null,
        postSort: null,
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
      this.getListTitle();
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
      this.openAdd = true;
      this.title = "添加 新掠影类型";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTeamOverviewTitle(id).then(response => {
        this.form = response.data;

        teamOverview.titleId = this.form.id;

        // 设置 index 的 open 为 true
        teamOverview.indexOpen = true;
        // 存储 row 和 ids
        teamOverview.titleRow = row;
        teamOverview.titleIds = this.ids;
        // 设置 auto 为 true 以自动打开编辑页面
        teamOverview.auto = true;

        // 直接刷新
        this.reload();
      });
    },
    handleUpdateAuto(row) {
      this.reset();
      const id = row.id || this.ids
      getTeamOverviewTitle(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改 " + this.form.title;

        teamOverview.titleId = this.form.id;
      });
    },
    /** 刷新后自动打开修改页面 */
    autoOpenUpdatePage() {
      if (teamOverview.titleRow != null && teamOverview.auto === true) {
        // 关闭自动打开 只打开一次
        teamOverview.auto = false;
        // 设置选中数组
        this.ids = teamOverview.titleIds;

        this.handleUpdateAuto(teamOverview.titleRow);
      }
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateTeamOverviewTitle(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.openAdd = false;
              this.getListTitle();
            });
          } else {
            addTeamOverviewTitle(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.openAdd = false;
              this.getListTitle();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      this.queryParams.titleId = '';
      listTeamOverviewImg().then(response => {
        this.teamOverviewImgList = response.rows;

        // 判断 所选中的团队掠影 中是否有图片
        this.totalImg = response.total;

        let hasImg = new Map;
        for (let i = 0; i < this.totalImg; i++) {
          let teamOverviewImg = this.teamOverviewImgList[i];
          let teamOverviewImgArray = Object.values(teamOverviewImg);
          let teamOverviewImgId = teamOverviewImgArray[8];
          hasImg.set(teamOverviewImgId, true);
        }

        let ids = row.id || this.ids;

        if (!Array.isArray(ids)) {
          ids = Array.of(ids);
        }

        let needDeleteImg = [];
        for (let i = 0; i < ids.length; i++) {
          if (hasImg.get(ids[i]) === true) {
            needDeleteImg.push(ids[i]);
          }
        }

        if (needDeleteImg.length > 0) {
          // 如果有图片则提示
          this.$modal.msgWarning('请先删除Id为"' + needDeleteImg + '"的分类中的图片~');
        } else {
          // 没有图片则进入删除流程
          this.$modal.confirm('是否确认删除Id为"' + ids + '"的数据项？').then(function() {
            return delTeamOverviewTitle(ids);
          }).then(() => {
            this.getListTitle();
            this.$modal.msgSuccess("删除成功");
          }).catch(() => {});
        }

        // twinkling闪烁1s
        this.twinkling();
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('/nlp/admission/teamOverviewTitle/export', {
        ...this.queryParams
      }, `teamOverviewTitle_${new Date().getTime()}.xlsx`)
    },
  }
};
</script>
