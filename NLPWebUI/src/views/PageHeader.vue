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
    methods:{
        handleSelect(url)
        {
            if(url=='1')
            {
                this.$router.push('/')
            }
            else if(url=='5')
            {
                this.$router.push('newslist')
            }
            else if(url=='6') {
                this.$router.push('/academicresource')
            }
            else if(url=='7')
            {
                this.$router.push('/studentmanage')
            }
            else if(url=='8')
            {
                this.$router.push('/teamoverview')
            }
            else if(url=='9')
            {
                this.$router.push('/studentcultivation')
            }
        }
    }
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

              <el-menu :default-active="1"
                       @select="handleSelect">
                  <el-menu-item index="1">首页</el-menu-item>
                  <el-menu-item index="2">研究方向</el-menu-item>
                  <el-sub-menu index="3" >
                      <template #title>团队成员</template>
                      <el-menu-item index="3-1">学术顾问</el-menu-item>
                      <el-menu-item index="3-2">带头人</el-menu-item>
                      <el-menu-item index="3-3">团队教师</el-menu-item>
                      <el-menu-item index="3-4">合作专家</el-menu-item>
                      <el-menu-item index="3-5">在读学生</el-menu-item>
                  </el-sub-menu>
                  <el-menu-item index="4">科研成果</el-menu-item>
                  <el-menu-item index="5">团队新闻</el-menu-item>
                  <el-menu-item index="6">学术资源</el-menu-item>
                  <el-menu-item index="7">桃李芬芳</el-menu-item>
                  <el-menu-item index="8">团队掠影</el-menu-item>
                  <el-menu-item index="9">人才招聘</el-menu-item>
              </el-menu>

          </el-drawer>

        </div>
  <div id="headTitle-d01">

        <div id="headTitle01">
          <img src="../assets/images/logo.svg" style="height:3.35rem;">
        </div>
        <div id="headTitle02">
            自然语言处理及认知计算研究团队<br>
            <span id="headTitle-englishName"><nobr>Research Group for Natural Language Processing </nobr><wbr><nobr>and Cognitive Computing</nobr></span>
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
      .el-menu {
           border-right: 0px
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
</style>
