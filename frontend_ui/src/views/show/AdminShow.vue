<template>
  <h2>{{ collectionList.title }}</h2>
  <div v-for="(item, index) in collectionList.topicCollections" :key="index">
    <h3>{{ item.name }}</h3>
    <v-md-preview :text="item.recordContent"></v-md-preview>
  </div>
  <div
    v-loading.fullscreen.lock="loading"
    element-loading-text="加载中"
    element-loading-spinner="el-icon-loading"
    element-loading-background="rgba(0, 0, 0, 0.8)"
  ></div>
</template>

<script>
import { listCollection } from "@/api/show/collection";

export default {
  name: "AdminShow",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 管理员登录界面介绍内容
      collectionList: {
        title: "",
        topicCollections: {},
      },
    };
  },
  created() {
    // 获取云盘介绍内容
    this.getCollectionList();
  },
  methods: {
    /** 获取管理员登录界面介绍内容 */
    getCollectionList() {
      this.loading = true;
      listCollection("qlu_topic_collection", "admin").then((response) => {
        this.collectionList = response.data[0];
        this.total = response.total;
        this.loading = false;
      });
    },
  },
  mounted() {},
};
</script>

<style scoped></style>
