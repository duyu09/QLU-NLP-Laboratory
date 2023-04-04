<script>
import { RouterLink, RouterView } from 'vue-router';
import { ElMessageBox } from 'element-plus';
import { ArrowDown } from '@element-plus/icons-vue';


export default
{
    name:'PageHeader',
    components:
    {
      ArrowDown:'arrow-down',
    },
    data(){
      return {
        drawer:false,
      }
    },
}
</script>
<template>
  <div id="headTitle-shortname">
          <span style="font-family: censcbk;font-weight: 600;">
            QLU
          </span>
          <span style="font-size: 1.55rem;font-weight:100;display:inline-block;font-style: italic;margin-left: 0.4rem;">
            NLP实验室
          </span>

          <el-button type="primary" style="margin-left: 1.85rem;background-color: transparent;" @click="drawer = true">
            <!-- <div style="background-image: url('../src/assets/images/small_menu.svg');height:100%;width: 100%;"></div> -->
            MENU
          </el-button>
          <el-drawer v-model="drawer" title="QLU NLP Labs" size="50%">


            <el-dropdown>
              <span class="el-dropdown-link" style="font-size: larger;outline: 0 !important;">
                    首页
                <el-icon class="el-icon--right">
                    <arrow-down />
                </el-icon>
              </span>
            </el-dropdown>


            
            <el-dropdown>
              <span class="el-dropdown-link" style="font-size: larger;outline: none;">
                    实验室概况
                <el-icon class="el-icon--right">
                    <arrow-down />
                </el-icon>
              </span>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item>科研方向</el-dropdown-item>
                  <el-dropdown-item>科研成果</el-dropdown-item>
                  <el-dropdown-item>实验室简介</el-dropdown-item>
                  <!-- <el-dropdown-item disabled>Action 4</el-dropdown-item>
                  <el-dropdown-item divided>Action 5</el-dropdown-item> -->
                </el-dropdown-menu>
              </template>
            </el-dropdown>


            <el-dropdown>
              <span class="el-dropdown-link" style="font-size: larger;outline: none;">
                    科研项目
                <el-icon class="el-icon--right">
                    <arrow-down />
                </el-icon>
              </span>
              <template #dropdown>
              </template>
            </el-dropdown>



            <el-dropdown>
              <span class="el-dropdown-link" style="font-size: larger;outline: none;">
                    人才管理
                <el-icon class="el-icon--right">
                    <arrow-down />
                </el-icon>
              </span>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item>人才培养</el-dropdown-item>
                  <el-dropdown-item>人才招聘</el-dropdown-item>
                  <!-- <el-dropdown-item disabled>Action 4</el-dropdown-item>
                  <el-dropdown-item divided>Action 5</el-dropdown-item> -->
                </el-dropdown-menu>
              </template>
            </el-dropdown>

          </el-drawer>

        </div>
  <div id="headTitle-d01">
          
        <div id="headTitle01">
          <!-- <span style="font-family: maozedong;"><nobr>齐鲁工业大学 (山东省科学院)</nobr></span> -->
          <img src="../assets/images/logo.svg" style="height:3.35rem;">
        </div>
        <div id="headTitle02">
            自然语言处理及认知计算实验室<br>
            <span id="headTitle-englishName"><nobr>Laboratory of Natural Language Processing </nobr><wbr><nobr>and Cognitive Computing</nobr></span>
        </div>
        <div id="headTitle03"></div>
        
  </div>
</template>
<style>
  *
  {
   margin: 0;
   padding: 0;
  }
  #headTitle-englishName
  {
    font-size: smaller;color: rgb(155, 240, 255);font-family: censcbk;
  }
  #headTitle-d01
  {
    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei', '微软雅黑', Arial, sans-serif;
    background-image: linear-gradient(to right, rgb(0, 85, 255), rgb(0, 0, 108));
    color: white;
    height:5.4rem;
    padding-top: 0rem;
    display: flex;
    align-items: center;
    padding-left: 1.25rem;
  }
  #headTitle01
  {
    font-size: 2rem;
    line-height: 2rem;
    margin-left: 5.5rem;
    flex-grow: 2;
  }
  #headTitle02
  {
    flex-grow: 13;
    font-size: 1.15rem;
    font-style: italic;
    margin-top: 0;
    padding-left: 1rem;
  }
  #headTitle03
  {
    flex-grow: 8;
  }
  #headTitle-shortname
  {
    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei', '微软雅黑', Arial, sans-serif;
    color: white;
    height:4.75rem;
    padding-top: 1.4rem;
    display: flex;
    align-items: center;
    padding-left: 0.5rem;
    display: none;
    font-size: 1.8rem;
    outline: 0;
  }
  @media screen and (max-width: 40rem) 
  {
    #headTitle-d01
    {
      background-image: linear-gradient(to right,rgb(16,83,151),rgb(16,83,151));
      padding-left: 0;
      display: flex;
      justify-content: center;
    }
    #headTitle01
    {
        display: none;
        margin-left: 0;
        padding:0;
        font-size: 1.6rem;
        flex-grow: 0;
    }
    #headTitle02
    {
        display: none;
    }
    #headTitle03
    {
        flex-grow: 0;
    }
    #headTitle-shortname
    {
        display: inline;
        position: absolute;
        left: 2rem;
    }
  }
  #headTitle-shortname .el-dropdown:focus-visible
  {
    outline: 0;
  }
  #headTitle-shortname .example-showcase .el-dropdown-link 
  {
  cursor: pointer;
  display: flex;
  align-items: center;
  }
  @font-face {
    font-family: censcbk;
    src: url("../assets/fonts/censcbk.woff");
  }
  @font-face {
    font-family: maozedong;
    src: url("../assets/fonts/maozedong.woff");
  }
</style>
