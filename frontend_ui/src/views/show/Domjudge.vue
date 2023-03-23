<template>
  <h2>{{ collectionList.title }}</h2>
  <div v-for="(item, index) in collectionList.topicCollections" :key="index">
    <div style="text-align: left;">
      <v-md-preview :text="item.recordContent"></v-md-preview>
    </div>
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
  name: "Domjudge",
  data() {
    return {
      // 遮罩层
      loading: true,
      // domjudge数据
      collectionList: {
        title: "",
        topicCollections: {},
      },
    };
  },
  created() {
    // 获取domjudge数据
    this.getCollectionList();
  },
  methods: {
    /** 获取domjudge数据 */
    getCollectionList() {
      this.loading = true;
      listCollection("qlu_topic_collection", "domjudge").then((response) => {
        this.collectionList = response.data[0];
        // this.title = response.data[0].title;
        // this.topicCollections = response.data[0].topicCollections;
        this.total = response.total;
        this.loading = false;
      });
    },
  },
};
</script>

<style scoped></style>
