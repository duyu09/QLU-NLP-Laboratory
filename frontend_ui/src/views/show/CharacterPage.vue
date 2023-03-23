<template>
  <div>
    <div class="breadcrumb_box">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/' }">人物志</el-breadcrumb-item>
        <el-breadcrumb-item>{{ peopleClass }}</el-breadcrumb-item>
        <el-breadcrumb-item>{{ showCharacter.nameTitle }}</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div style="text-align: left;">
      <v-md-preview :text="showCharacter.recordContent"></v-md-preview>
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
import { getCharacter } from "@/api/show/character";
import { getDicts } from "@/api/show/config/date";

export default {
  name: "CharactersPage",
  data() {
    return {
      // 遮罩层
      loading: true,
      peopleClass: "",
      nameTitle: "",
      // 人物志数据
      showCharacter: {},
      // 分类数据
      dictType: {},
    };
  },
  mounted() {},
  created() {
    // 获取人物志详细信息
    this.getCharacter(this.$route.query.characterId);
    // 获取人物志类别
    this.getDicts("qlu_character");
  },
  methods: {
    /** 获取详细信息 */
    getCharacter(id) {
      this.loading = true;
      getCharacter(id).then((response) => {
        this.showCharacter = response.data;
        this.open = true;
        this.title = "人物志详细信息";
        this.loading = false;
      });
    },
    /** 获取详细信息 */
    getDicts(type) {
      this.loading = true;
      getDicts(type).then((response) => {
        this.dictType = response.data;
        this.setTypeByDicts(response.data, this.$route.query.configId);
        this.loading = false;
      });
    },
    //  对分类数据进行回显
    setTypeByDicts(configList, configId) {
      const that = this;
      configList.forEach(function (item) {
        if (item.dictValue === configId) {
          that.peopleClass = item.dictLabel;
        }
      });
    },
  },
};
</script>

<style scoped>
.breadcrumb_box {
  height: 30px;
  padding-left: 30px;
  padding-top: 20px;
  background-color: #f5f5f5;
}
</style>
