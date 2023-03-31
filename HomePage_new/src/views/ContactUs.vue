<script>
import { RouterLink, RouterView } from 'vue-router'
import 'element-plus/dist/index.css';
export default
{
    name:'ContactUs'
}
</script>
<template>
    <div style="margin-bottom: 1rem;">
        <el-tag class="mx-1" effect="dark" style="height:2.5rem;font-size: 1.6rem;">
            联系我们
        </el-tag>
        <el-divider border-style="dotted" style="margin: 0;padding: 0;" />
        <el-divider border-style="dashed" style="margin: 0;padding: 0;" />
        <div style="padding-top: 2rem;padding-bottom: 2rem;padding-left: 3.5rem;padding-right: 3.5rem;">
            本实验室研究经费及研究生指标充足（可为研究生提供良好科研环境以及发展机会），与国内外著名高校和研究机构有紧密合作：<br><br>

           （1）欢迎青年老师和有意从事学术研究的博士后、博士生、硕士生、本科生加入（或访问）本课题组；<br><br>

           <b>【青年教师/博士后待遇】：学校薪资+学院补贴+实验室补贴 （35-45w，根据个人能力具体面议）</b><br><br>

           （2）欢迎高年级本科生参与实验室科研实习（可推荐至美国、新加坡、微软亚洲研究院等世界知名大学/机构攻读博士学位）。<br><br>

           <b>【联系方式】：weiw@hust.edu.cn </b>
        </div>
    </div>
</template>