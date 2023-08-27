<script>
import { RouterLink, RouterView } from 'vue-router'
import {getIntroductionHttp} from '../api.js'
import 'element-plus/dist/index.css';
export default
{
    name:'Introduction',
    data(){
        return{
            content:''
        }
    },
    mounted() {
        getIntroductionHttp().then(res=>{
            var a=res.data.data.recordContent
            console.log(a)
            this.content=res.data.data.recordContent
        })
    }
}
</script>
<template>
<div style="display: block;" id="intro-div01">
    <el-tag class="mx-1" effect="dark" id="intro-tag01">
      实验室简介
    </el-tag>
    <el-divider border-style="dotted" style="margin: 0;padding: 0;" />
    <el-divider border-style="dashed" style="margin: 0;padding: 0;" />
    <div id="intro-div02" >
        <v-md-preview :text="content" style="width: 100%;"></v-md-preview>
    </div>
</div>
</template>
<style>
#intro-div01
{
    display: block;
    padding: 1.25rem;
}
#intro-div02
{
    margin-top: 2rem;margin-bottom: 2rem;
}
#intro-tag01
{
    height:2.5rem;font-size: 1.6rem;
}
@media screen and (max-width: 40rem)
{
    #intro-div01
    {
        font-size: smaller;
        padding-left: 1.8rem;
        padding-right: 1.8rem;
    }
    #intro-tag01
    {
        padding-left: 0.5rem;
    }
    #intro-div02
    {
        margin-top: 0.8rem;
        margin-bottom: 0.8rem;
    }
}
</style>
