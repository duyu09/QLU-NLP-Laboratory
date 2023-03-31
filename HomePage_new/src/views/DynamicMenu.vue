<script>
import { RouterLink, RouterView } from 'vue-router';
export default
{
    name:'DynamicMenu',
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
        <div v-for="item in MenuArray">{{ item.name }}</div>
    </div>
</template>
<style>
/* 组件的背景颜色在APP.VUE里调 */ 
#mainDynamicMenu
{
    display: flex;
}
#mainDynamicMenu > div
{
    flex-grow: 1;
    text-align: center;
    padding-top: 1rem;
    padding-bottom: 1rem;
}
#mainDynamicMenu > div:hover
{
    background-color: #55ABDA;
    color: white;
    cursor: pointer;
}
</style>
