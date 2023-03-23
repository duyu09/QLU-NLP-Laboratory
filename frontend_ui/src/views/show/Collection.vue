<template>
  <h2>训练题集</h2>
  <!-- PC适配-->
  <el-tabs
    class="windows-box"
    v-model="activeName"
    tab-position="left"
    @tab-click="handleClick"
  >
    <el-tab-pane
      v-for="(item, indexs) in collectionList"
      :key="indexs"
      :label="item.title"
    >
      <el-tabs
        v-if="item.topicCollections[0] != null"
        type="card"
        tab-position="top"
      >
        <el-tab-pane
          v-for="(collection, index) in item.topicCollections"
          :key="index"
          :label="collection.name"
        >
          <div style="width: 90%; padding-left: 5%; text-align: left;">
            <div v-if="collection.recordContent != null">
              <v-md-preview :text="collection.recordContent"></v-md-preview>
            </div>
            <div v-else>
              {{ InfoArray.notShow }}
            </div>
          </div>
        </el-tab-pane>
      </el-tabs>
      <div v-else>
        {{ InfoArray.notHave }}
      </div>
    </el-tab-pane>
  </el-tabs>
  <!-- 移动端适配-->
  <el-collapse class="mobile-box" v-model="activeNames" @change="handleChange">
    <el-collapse-item
      v-for="(item, indexs) in collectionList"
      :name="indexs"
      :title="item.title"
      :key="indexs"
    >
      <el-tabs
        v-if="item.topicCollections[0] != null"
        type="card"
        tab-position="top"
      >
        <el-tab-pane
          v-for="(collection, index) in item.topicCollections"
          :key="index"
          :label="collection.name"
        >
          <div style="width: 90%; padding-left: 5%">
            <div v-if="collection.recordContent != null">
              <v-md-preview :text="item.recordContent"></v-md-preview>
            </div>
            <div v-else>
              {{ InfoArray.notShow }}
            </div>
          </div>
        </el-tab-pane>
      </el-tabs>
      <div v-else>
        {{ InfoArray.notHave }}
      </div>
    </el-collapse-item>
  </el-collapse>

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
  name: "Collection",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 题集数据
      collectionList: [],
      // 展示的提示内容
      InfoArray: {
        notShow: "内容还待完善",
        notHave: "内容还待填充",
      },
    };
  },
  created() {
    // 获取题集数据
    this.getCollectionList();
  },
  methods: {
    /** 获取题集数据 */
    getCollectionList() {
      this.loading = true;
      listCollection("qlu_topic_collection", "topic ").then((response) => {
        this.collectionList = response.data;
        this.total = response.total;
        this.loading = false;
      });
    },
  },
  mounted() {},
};
</script>

<style scoped></style>
