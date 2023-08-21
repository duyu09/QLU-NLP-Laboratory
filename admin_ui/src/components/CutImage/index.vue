<template>
  <div>
    <div class="user-info-head" @click="editCropper()"><img v-bind:src="this.showImgUrl+imgPath" title="点击上传图片" class="img-lg" /></div>
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body @opened="modalOpened"  @close="closeDialog">
      <el-row>
        <el-col :xs="24" :md="12" :style="{height: '350px'}">
          <vue-cropper
            ref="cropper"
            :img="options.img"
            :info="true"
            :autoCrop="options.autoCrop"
            :autoCropWidth="options.autoCropWidth"
            :autoCropHeight="options.autoCropHeight"
            :fixedBox="options.fixedBox"
            outputType="png"
            @realTime="realTime"
            v-if="visible"
          />
        </el-col>
        <el-col :xs="24" :md="12" :style="{height: '350px'}">
          <div class="cut-image-upload-preview">
            <img :src="previews.url" :style="previews.img" />
          </div>
        </el-col>
      </el-row>
      <br />
      <el-row>
        <el-col :lg="2" :md="2">
          <el-upload action="#" :http-request="requestUpload" :show-file-list="false" :before-upload="beforeUpload">
            <el-button size="small">
              选择
              <i class="el-icon-upload el-icon--right"></i>
            </el-button>
          </el-upload>
        </el-col>
        <el-col :lg="{span: 1, offset: 2}" :md="2">
          <el-button icon="el-icon-plus" size="small" @click="changeScale(1)"></el-button>
        </el-col>
        <el-col :lg="{span: 1, offset: 1}" :md="2">
          <el-button icon="el-icon-minus" size="small" @click="changeScale(-1)"></el-button>
        </el-col>
        <el-col :lg="{span: 1, offset: 1}" :md="2">
          <el-button icon="el-icon-refresh-left" size="small" @click="rotateLeft()"></el-button>
        </el-col>
        <el-col :lg="{span: 1, offset: 1}" :md="2">
          <el-button icon="el-icon-refresh-right" size="small" @click="rotateRight()"></el-button>
        </el-col>
        <el-col :lg="{span: 2, offset: 6}" :md="2">
          <el-button type="primary" size="small" @click="uploadImg()">提 交</el-button>
        </el-col>
      </el-row>
    </el-dialog>
  </div>
</template>

<script>
import store from "@/store";
import { VueCropper } from "vue-cropper";
import { MessageBox } from 'element-ui'
import { getToken } from "@/utils/auth";

export default {
  components: { VueCropper },
  props: {
    imgPath: {
      type: String
    },
    autoCropWidth: {
      type: Number,
      default: 240,
    },
    autoCropHeight: {
      type: Number,
      default: 240,
    },
    // 图片数量限制
    limit: {
      type: Number,
      default: 1,
    },
    // 大小限制(MB)
    fileSize: {
      type: Number,
      default: 50,
    },
    // // 文件类型, 例如['png', 'jpg', 'jpeg']
    // fileType: {
    //   type: Array,
    //   default: () => ["png", "jpg", "jpeg"],
    // },
  },
  data() {
    return {
      // 图片显示路径
      showImgUrl: process.env.VUE_APP_BASE_API,
      // 上传地址
      uploadImgUrl: process.env.VUE_APP_BASE_API + "/common/upload", // 上传的图片服务器地址
      headers: {
        Authorization: "Bearer " + getToken(),
      },
      // 是否显示弹出层
      open: false,
      // 是否显示cropper
      visible: false,
      // 弹出层标题
      title: "裁切图片",
      fileType: ["png", "jpg", "jpeg"],
      options: {
        img: this.showImgUrl + this.imgPath, //裁剪图片的地址
        autoCrop: true, // 是否默认生成截图框
        autoCropWidth: this.autoCropWidth, // 默认生成截图框宽度
        autoCropHeight: this.autoCropHeight, // 默认生成截图框高度
        fixedBox: true // 固定截图框大小 不允许改变
      },
      previews: {}
    };
  },
  methods: {
    // 编辑头像
    editCropper() {
      this.open = true;
    },
    // 打开弹出层结束时的回调
    modalOpened() {
      this.visible = true;
    },
    // 向左旋转
    rotateLeft() {
      this.$refs.cropper.rotateLeft();
    },
    // 向右旋转
    rotateRight() {
      this.$refs.cropper.rotateRight();
    },
    // 图片缩放
    changeScale(num) {
      num = num || 1;
      this.$refs.cropper.changeScale(num);
    },
    // 上传文件之前的钩子
    beforeUpload(file) {
      let isImg = false;
      if (this.fileType.length) {
        let fileExtension = "";
        if (file.name.lastIndexOf(".") > -1) {
          fileExtension = file.name.slice(file.name.lastIndexOf(".") + 1);
        }
        isImg = this.fileType.some((type) => {
          if (file.type.indexOf(type) > -1) return true;
          if (fileExtension && fileExtension.indexOf(type) > -1) return true;
          return false;
        });
      } else {
        isImg = file.type.indexOf("image") > -1;
      }

      if (!isImg) {
        this.$message.error(
          `文件格式不正确, 请上传${this.fileType.join("/")}图片格式文件!`
        );
        return false;
      }
      if (this.fileSize) {
        const isLt = file.size / 1024 / 1024 < this.fileSize;
        if (!isLt) {
          this.$message.error(`上传头像图片大小不能超过 ${this.fileSize} MB!`);
          return false;
        }
      }
      this.loading = this.$loading({
        lock: true,
        text: "上传中",
        background: "rgba(0, 0, 0, 0.7)",
      });
    },
    // 覆盖默认的上传行为
    requestUpload(param) {
      // 拿到 files 之后上传到文件服务器，然后向编辑框中插入对应的内容
      const forms = new FormData();
      const configs = {
        headers: this.headers,
      };
      forms.append("file", param.file);
      this.axios.post(this.uploadImgUrl, forms, configs).then((res) => {
        if (res.data.code === 200) {
          this.options.img = this.showImgUrl + res.data.fileName;
        } else if (res.data.code === 401) {
          // eslint-disable-next-line no-undef
          MessageBox.confirm(
            "登录状态已过期，您可以继续留在该页面，或者重新登录",
            "系统提示",
            {
              confirmButtonText: "重新登录",
              cancelButtonText: "取消",
              type: "warning",
            }
          )
            .then(() => {
              store.dispatch("LogOut").then(() => {
                location.href = "/login";
              });
            })
            .catch(() => {});
        } else {
          this.$message.error("图片填入失败");
        }
        this.loading.close();
      });
    },
    // 上传图片
    uploadImg() {
      this.$refs.cropper.getCropBlob((data) => {
        let formData = new FormData();
        formData.append("file", data);
        // 拿到 files 之后上传到文件服务器，然后向编辑框中插入对应的内容
        const configs = {
          headers: this.headers,
        };
        this.axios.post(this.uploadImgUrl, formData, configs).then((res) => {
          if (res.data.code === 200) {
            this.options.img = this.showImgUrl + res.data.fileName;
            this.$emit("nowImg", res.data.fileName);
            this.open = false;
          } else if (res.data.code === 401) {
            // eslint-disable-next-line no-undef
            ElMessageBox.confirm(
              "登录状态已过期，您可以继续留在该页面，或者重新登录",
              "系统提示",
              {
                confirmButtonText: "重新登录",
                cancelButtonText: "取消",
                type: "warning",
              }
            )
              .then(() => {
                store.dispatch("LogOut").then(() => {
                  location.href = "/login";
                });
              })
              .catch(() => {});
          } else {
            this.$message.error("图片选择失败");
          }
        });
      });
    },
    // 实时预览
    realTime(data) {
      this.previews = data;
    },
    // 关闭窗口
    closeDialog() {
      this.options.img = store.getters.avatar
      this.visible = false;
    }
  }
};
</script>
<style scoped lang="scss">
.user-info-head {
  position: relative;
  display: inline-block;
  height: 120px;
}

.user-info-head:hover:after {
  content: '+';
  text-align:center;
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  color: #eee;
  background: rgba(0, 0, 0, 0.5);
  font-size: 24px;
  font-style: normal;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  cursor: pointer;
  line-height: 110px;
}

.cut-image-upload-preview {
  position: absolute;
  top: 50%;
  transform: translate(35%, -50%);
  width: 240px;
  height: 240px;
  box-shadow: 0 0 4px #ccc;
  overflow: hidden;
}

</style>
