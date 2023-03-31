<script>
import pageHeader from "./views/PageHeader.vue";
import dynamicMenu from "./views/DynamicMenu.vue";
import rotoGraph from "./views/RotoGraph.vue";
import introduction from "./views/Introduction.vue";
import news from "./views/News.vue";
import contactUs from "./views/ContactUs.vue";
import connect from "./views/Connect.vue";
import foot from "./views/Footer.vue";
import 'element-plus/dist/index.css';
export default
{
  components:
  {
    "pHeader":pageHeader,
    "dynamicMenu":dynamicMenu,
    "rotoGraph":rotoGraph,
    "introduction":introduction,
    "news":news,
    "contactUs":contactUs,
    "connect":connect,
    "foot":foot,
  }
}
</script>
<template>
  <p-header></p-header>
  <div id="mainDiv">
    <div style="display: flex;justify-content: center;background-color: #cbedff;">
      <div style="width: 85%;">
        <dynamicMenu></dynamicMenu>
      </div>
    </div>
    <div style="display: flex;justify-content: center;">
      <div style="width: 85%;">
        <rotoGraph></rotoGraph>
      </div>
    </div>
    <div style="display: flex;justify-content: center;margin-top: 2rem;">
      <div style="width: 85%;">
        <el-row>
        <el-col :span="9"><introduction></introduction></el-col>
        <el-col :span="15"><news></news></el-col>
        </el-row>
      </div>
    </div>
    <div style="display: flex;justify-content: center;margin-top: 0.5rem;">
      <div style="width: 85%;">
        <contactUs></contactUs>
      </div>
    </div>
    <div style="display: flex;justify-content: center;margin-top: 0.5rem;">
      <div style="width: 85%;">
        <connect></connect>
      </div>
    </div>
  </div>
  <foot></foot>
</template>