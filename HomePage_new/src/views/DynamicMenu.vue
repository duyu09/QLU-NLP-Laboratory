<script>
import { RouterLink, RouterView } from 'vue-router';
import { ArrowDown } from '@element-plus/icons-vue';
export default
{
    name:'DynamicMenu',
    components:
    {
      ArrowDown:'arrow-down',
    },
    data() 
    {
       return{
            MenuArray:
            [
                {name:'首页',anchor:'/'},
                {name:'实验室概况',anchor:'/'},
                {name:'科研项目',anchor:'/'},
                {name:'人才管理',anchor:'/'}
            ]
       }
    }
}
</script>
<template>
    <div id="mainDynamicMenu">
        <!-- <div v-for="item in MenuArray">{{ item.name }}</div> -->

        <div>
            <el-dropdown>
              <span class="el-dropdown-link" style="font-size: larger;outline: 0 !important;">
                    首页
                <el-icon class="el-icon--right">
                    <arrow-down />
                </el-icon>
              </span>
            </el-dropdown>
        </div>

        <div>
            <el-dropdown>
              <span class="el-dropdown-link" style="font-size: larger;outline: 0 !important;">
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
        </div>

        <div>
            <el-dropdown>
              <span class="el-dropdown-link" style="font-size: larger;outline: 0 !important;">
                    科研项目
                <el-icon class="el-icon--right">
                    <arrow-down />
                </el-icon>
              </span>
              <template #dropdown>
              </template>
            </el-dropdown>
        </div>
        
        <div>
            <el-dropdown>
              <span class="el-dropdown-link" style="font-size: larger;outline: 0 !important;">
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
        </div>

    </div>
</template>
<style>
/* 组件的背景颜色在APP.VUE里调 */ 
#mainDynamicMenu
{
    display: flex;
    height: 3rem;
}
#mainDynamicMenu > div
{
    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei', '微软雅黑', Arial, sans-serif;
    flex-grow: 1;
    text-align: center;
    padding-top: 0.75rem;
    padding-bottom: 1rem;
}
#mainDynamicMenu > div >.el-dropdown:hover,#mainDynamicMenu > div:hover
{
    cursor: pointer;
    animation: dm-keyframe01 0.5s;
    animation-fill-mode: forwards;
    /* background-color: #acccff; */
}
#mainDynamicMenu div.el-dropdown
{
    line-height: 1.5rem !important;
    outline: 0 !important;
    color: black;
    height: 100%;
}
@keyframes dm-keyframe01 
{
  to
  {
    background-color: #acccff;
  }
}

</style>
