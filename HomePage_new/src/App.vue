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
  <div id="mainDiv" style="background-color: rgb(231,231,231);">
    <div style="display: flex;justify-content: center;background-color: rgb(248,248,248);box-shadow: 0 .125rem .1875rem black;">
      <div style="width: 85%;">
        <dynamicMenu></dynamicMenu>
      </div>
    </div>
    <div style="display: flex;justify-content: center;margin-top: .625rem;">
      <div style="width: 85%;">
        <rotoGraph></rotoGraph>
      </div>
    </div>
    <div style="display: flex;justify-content: center;">
      <div style="width: 85%;background-color: white;padding-top: .825rem;">
        <el-row id="i_and_n01">
        <el-col :span="9"><introduction></introduction></el-col>
        <el-col :span="15"><news></news></el-col>
        </el-row>
        <div id="i_and_n02">
          <introduction></introduction>
          <news></news>
        </div>
      </div>
    </div>
    <div style="display: flex;justify-content: center;margin-top: 0.5rem;">
      <div style="width: 85%;background-color: white;">
        <contactUs></contactUs>
      </div>
    </div>
    <div style="display: flex;justify-content: center;margin-top: 0.5rem;">
      <div style="width: 85%;background-color: white;margin-bottom: 0.5rem;">
        <connect></connect>
      </div>
    </div>
  </div>
  <foot></foot>
  
</template>
<style>
@media screen and (max-width: 40rem) 
{
    #i_and_n01
    {
        display: none;
    }
    #i_and_n02
    {
        display: inline-block;
    }
}
</style>