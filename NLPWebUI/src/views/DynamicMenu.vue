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
    },
    methods:{
      handleSelect(url)
      {
        if(url=='1')
        {
          this.$router.push('/')
        }
        else if(url=='4-1')
        {
          this.$router.push('/studentmanage')
        }
        else if(url=='4-2')
        {
          this.$router.push('/studentcultivation')
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

    <div id="mainDynamicMenu">
        <el-menu :default-active="1"
                 class="mainDynamicMenu"
                 mode="horizontal"
                 @select="handleSelect"
                 ellipsis=false>
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
    </div>
</template>
<style scoped>
/* 组件的背景颜色在APP.VUE里调 */ 

.el-menu--horizontal {
    justify-content: space-evenly;
}
@media screen and (max-width: 40rem)
{
    #mainDynamicMenu{
        display: none;
    }
}
</style>
