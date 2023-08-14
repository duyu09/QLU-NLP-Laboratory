<script>
import { RouterLink, RouterView } from 'vue-router'
import 'element-plus/dist/index.css';
import { Link } from '@element-plus/icons-vue';
import {getFriendLink} from "../api";
export default
{
    name:'Connect',
    components:
    {
        "Link":Link,
    },
    data(){
        return{
            linklist:[]
        }
    },
    mounted() {
        getFriendLink()
        .then(res=>{
            console.log(res.data.data)
            this.linklist=res.data.data
        })
    },
    methods:{
        golink(url){
            window.open(url);
        }
    }
}
</script>
<template>
    <div style="font-size: smaller;padding: 1.8rem;">
        <el-tag class="mx-1" effect="dark" style="height:2.5rem;font-size: 1.6rem;">
            友情链接
        </el-tag>
        <el-divider border-style="dotted" style="margin: 0;padding: 0;" />
        <el-divider border-style="dashed" style="margin: 0;padding: 0;" />
        <div id="conn-div01">
            <div v-for="item in linklist" key="item.id" @click="golink(item.linkUrl)">
                <nobr>
                    <el-icon><Link /></el-icon>
                    <span>{{item.linkName}}</span>
                </nobr>
            </div>
        </div>
    </div>
</template>
<style>
#conn-div01
{
    margin-top: 1rem;margin-bottom: 1rem;column-count: 4;column-gap:3rem;column-fill: balance;
    font-size: 1rem;
}
#conn-div01 > div
{
    height: 2rem;
}
#conn-div01 span
{
    cursor: pointer;
}
@media screen and (max-width: 40rem) 
{
    #conn-div01 .el-icon
    {
        display: none;
    }
    #conn-div01
    {
        column-count: 2;
        column-fill: balance;
        font-size: 0.5rem;
    }
}
</style>