<template>
  <div class="app-container">
    <el-form ref="form" :model="form" :rules="rules" label-width="80px">
      <el-row>
        <el-divider content-position="left">基础信息</el-divider>
        <el-col :span="6">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="form.name" placeholder="请输入姓名" disabled/>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="照片">
            <!--             <imageUpload v-model="form.imgUrl"/>-->
            <CutImage @nowImg="getImg" :imgPath="form.imgUrl"/>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="所在学校" prop="school">
            <el-input v-model="form.school" placeholder="请输入所在学校" />
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="所在学科" prop="subject">
            <el-input v-model="form.subject" placeholder="请输入所在学科" />
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="性别" prop="sex" disabled="">
            <el-select v-model="form.sex" placeholder="请选择性别">
              <el-option
                v-for="dict in dict.type.sys_user_sex"
                :key="dict.value"
                :label="dict.label" :value="dict.value"
              ></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="职称" prop="degree">
            <el-input v-model="form.degree" placeholder="请输入职称" />
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="form.email" placeholder="请输入邮箱" />
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="联系电话" prop="phone">
            <el-input v-model="form.phone" placeholder="请输入联系电话" />
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="成员身份" prop="professionalTitle">
            <el-select v-model="form.identity" placeholder="请输入" disabled>
              <el-option
                v-for="dict in dict.type.nlp_member_identity"
                :key="dict.value"
                :label="dict.label" :value="parseInt(dict.value)"
              ></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="状态" prop="status">
            <el-radio-group v-model="form.status">
              <el-radio
                v-for="dict in dict.type.sys_normal_disable"
                :key="dict.value" :label="dict.value"
              >{{dict.label}}</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="显示顺序" prop="postSort">
            <el-input-number v-model="form.postSort" controls-position="right" :min="1" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-divider content-position="left">详细信息</el-divider>
        <div v-for="(model, index) in form.teacherModuleList">
          <div>{{index+1}}.</div>
          <el-row :gutter="30">
            <el-col :span="6">
              <el-form-item label="标题" prop="title">
                <el-input v-model="model.title" placeholder="请输入标题" />
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="状态" prop="status">
                <el-radio-group v-model="model.status">
                  <el-radio
                    v-for="dict in dict.type.sys_normal_disable"
                    :key="dict.value" :label="dict.value"
                  >{{dict.label}}</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
            <el-col :push="1" :span="5">
              <el-button type="danger" :disabled="index == '0'" @click="deleteModel(index)">-</el-button>
            </el-col>
          </el-row>
          <el-form-item label="详细内容" prop="recordContent">
            <MarkdownEditor v-model="model.recordContent"></MarkdownEditor>
          </el-form-item>
        </div>
        <el-row :gutter="30">
          <el-col :push="19" :span="5">
            <el-button type="success"  @click="addModel()">+</el-button>
          </el-col>
        </el-row>
      </el-row>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-col :push="10" :span="3">
        <el-button type="primary" @click="submitForm">保 存</el-button>
      </el-col>
    </div>
  </div>
</template>

<script>
import {getTeacherUser} from "@/api/nlp/teacher";

export default {
  name: "TeacherEditInfo",
  dicts: ['sys_user_sex', 'sys_normal_disable', 'nlp_member_identity'],
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
      // 职称表格数据
      teacherList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数

      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        imgUrl: null,
        subject: null,
        school: null,
        sex: null,
        degree: null,
        professionalTitle: null,
        email: null,
        phone: null,
        identity: null,
        status: null,
        postSort: null,
        creatBy: null,
      },
      // 表单参数
      form: {
        imgUrl: '',
        teacherModuleList: [{teacherId: this.$route.params.teacherId, title:'', recordContent:'', status:'0' }]
      },
      // 表单校验
      rules: {
        name: [
          { required: true, message: "姓名不能为空", trigger: "blur" }
        ],
        school: [
          { required: true, message: "姓名不能为空", trigger: "blur" }
        ],
        degree: [
          { required: true, message: "学位不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "状态不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getTeacherById(this.$route.params.teacherId);
  },
  methods: {
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
        imgUrl: null,
        subject: null,
        school: null,
        sex: null,
        degree: null,
        professionalTitle: null,
        email: null,
        phone: null,
        identity: null,
        status: "0",
        postSort: null,
        creatBy: null,
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
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加职称";
    },
    /** 修改按钮操作 */
    getTeacherById(id) {
      getTeacherUser().then(response => {
        if (response.data.teacherModuleList.length == 0)  {
          response.data.teacherModuleList.push({teacherId: this.$route.params.teacherId, title:'', recordContent:'', status:'0' });
        }
        this.form = response.data;
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          updateTeacher(this.form).then(response => {
            if(response.code == '200') {
              this.$modal.msgSuccess("保存成功");
              this.getTeacherById(this.$route.params.teacherId);
            }else {
              this.$modal.msgError("保存失败");
            }
          });
        }
      });
    },
    addModel() {
      this.form.teacherModuleList.push({teacherId: this.$route.params.teacherId, title:'', recordContent:'', status:'0' });
    },
    deleteModel(index) {
      console.log(index)
      this.form.teacherModuleList.splice(index, 1);
    },
    // nowImg是由子组件传入的
    getImg(nowImg) {
      this.form.imgUrl = nowImg;
    },
  }
};
</script>
