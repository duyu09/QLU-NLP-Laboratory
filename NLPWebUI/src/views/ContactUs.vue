<script>
import { RouterLink, RouterView } from 'vue-router'
import 'element-plus/dist/index.css';
import {getConnectUs} from "../api";
export default
{
    name:'ContactUs',
    data(){
        return{
            content:""
        }
    },
    mounted() {
        getConnectUs()
        .then(res=>{
            console.log(res.data.data)
            this.content=res.data.data
        })
    }
}
</script>
<template>
    <div style="padding: 1.8rem;">
        <el-tag class="mx-1" effect="dark" style="height:2.5rem;font-size: 1.6rem;">
            联系我们
        </el-tag>
        <el-divider border-style="dotted" style="margin: 0;padding: 0;" />
        <el-divider border-style="dashed" style="margin: 0;padding: 0;" />
        <div id="cont-div01">
<!--            本实验室研究经费及研究生指标充足（可为研究生提供良好科研环境以及发展机会），与国内外著名高校和研究机构有紧密合作：<br><br>-->

<!--           （1）欢迎青年老师和有意从事学术研究的博士后、博士生、硕士生、本科生加入（或访问）本课题组；<br><br>-->

<!--           <b>【青年教师/博士后待遇】：学校薪资+学院补贴+实验室补贴 （35-45w，根据个人能力具体面议）</b><br><br>-->

<!--           （2）欢迎高年级本科生参与实验室科研实习（可推荐至美国、新加坡、微软亚洲研究院等世界知名大学/机构攻读博士学位）。<br><br>-->

<!--           <div id="cont-contact">-->
<!--                <b class="contact">【联系方式】：<br>联系人：鹿老师<br>联系电话：10000000000<br>邮箱：example@qq.com </b>-->
<!--           </div>-->
            <div v-for="item in content" key="item.id">
                <v-md-preview :text="item.recordContent" style="width: 100%;"></v-md-preview>
            </div>
        </div>
    </div>
</template>
<style>
#cont-contact
{
    display: none;
}
#cont-div01
{
    padding-top: 2rem;padding-bottom: 2rem;padding-left: 3.5rem;padding-right: 3.5rem;
}
@media screen and (max-width: 40rem) 
{
    #cont-div01
    {
        padding-left: 1rem;padding-right: 1rem;
        font-size: smaller;
    }
    #cont-contact
    {
        display: block;
    }
}
</style>