<template>
  <div>
    <div class="breadcrumb_box">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/' }">主页</el-breadcrumb-item>
        <el-breadcrumb-item>{{ announcementClass }}</el-breadcrumb-item>
        <el-breadcrumb-item>{{ showAnnouncement.title }}</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div>
      <v-md-preview :text="showAnnouncement.recordContent"></v-md-preview>
    </div>
    <div
      v-loading.fullscreen.lock="loading"
      element-loading-text="加载中"
      element-loading-spinner="el-icon-loading"
      element-loading-background="rgba(0, 0, 0, 0.8)"
    ></div>
  </div>
</template>

<script>
import { getAnnouncement } from "@/api/show/announcement";
import { getDicts } from "@/api/show/config/date";

export default {
  name: "Contribution",
  data() {
    return {
      // 遮罩层
      loading: true,
      announcementClass: "",
      nameTitle: "",
      // 公告数据
      showAnnouncement: {},
      // 分类数据
      dictType: {},
    };
  },
  mounted() {},
  created() {
    // 获取公告详细信息
    this.getAnnouncement(this.$route.query.announcementId);
    // 获取公告类别
    this.getDicts("qlu_announcement");
  },
  methods: {
    /** 获取详细信息 */
    getAnnouncement(id) {
      this.loading = true;
      getAnnouncement(id).then((response) => {
        this.showAnnouncement = response.data;
        this.open = true;
        this.title = "公告详细信息";
        // 修改 图片展示的 最大大小
        const regex = new RegExp("<img", "gi");
        this.showAnnouncement.recordContent =
          this.showAnnouncement.recordContent.replace(
            regex,
            `<img style="max-width: 100%; min-width: 400px;"`
          );
        this.loading = false;
      });
    },
    /** 获取详细信息 */
    getDicts(type) {
      this.loading = true;
      getDicts(type).then((response) => {
        this.dictType = response.data;
        this.loading = false;
      });
    },
    //  对分类数据进行回显
    setTypeByDicts(configList, configId) {
      const that = this;
      configList.forEach(function (item) {
        if (item.dictValue === configId) {
          that.announcementClass = item.dictLabel;
        }
      });
    },
  },
};
</script>

<style scoped></style>
