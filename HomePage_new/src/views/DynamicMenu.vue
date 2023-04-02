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
    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei', '微软雅黑', Arial, sans-serif;
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
@media screen and (max-width: 40rem){
    #mainDynamicMenu{
        display: flex;
        flex-direction: column;
        align-items: center;
        position: absolute;
        top: 2rem;
        right: 0.5rem;
        z-index: 4;
        background: rgb(20, 114, 208);
        width: 4rem;
        height: 2rem;
        overflow: hidden;
        border-radius: 0.5rem;
    }
    #mainDynamicMenu>div{
        display: flex;
        align-items: center;
        justify-content: center;
        padding-bottom: 0.5rem;
        padding-top: 0.5rem;
        height: 2rem;
        width: 100%;
        font-size: 0.5rem;
        background: rgb(20, 114, 208);
        transition: all 0.5s;
    }
    #mainDynamicMenu>div:not(:nth-child(1)){
        opacity:0;
    }
    #mainDynamicMenu:hover{
        overflow: visible;
    }
    #mainDynamicMenu:hover div{
        opacity: 1;
    }
}
</style>
