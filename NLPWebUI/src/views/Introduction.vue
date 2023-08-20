<script>
import { RouterLink, RouterView } from 'vue-router'
import 'element-plus/dist/index.css';
export default
{
    name:'Introduction'
}
</script>
<template>
<div style="display: block;" id="intro-div01">
    <el-tag class="mx-1" effect="dark" id="intro-tag01">
      实验室简介
    </el-tag>
    <el-divider border-style="dotted" style="margin: 0;padding: 0;" />
    <el-divider border-style="dashed" style="margin: 0;padding: 0;" />
    <div id="intro-div02">
        &nbsp;&nbsp;&nbsp;&nbsp;​齐鲁工业大学（山东省科学院）自然语言处理与认知计算研究团队，依托于计算机科学与技术学部、国家超级计算济南中心。
      团队面向国家和社会重大需求，聚焦于语言信息处理与多模态认知计算，重点探索文本语义分析、医疗健康信息处理与数据挖掘、多模态认知计算及推荐系统等领域的基础理论与关键技术。
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
