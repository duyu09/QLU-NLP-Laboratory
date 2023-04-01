<script>
import { RouterLink, RouterView } from 'vue-router'
import 'element-plus/dist/index.css';
import { Link } from '@element-plus/icons-vue';
export default
{
    name:'Connect',
    components:
    {
        "Link":Link,
    }
}
</script>
<template>
    <div style="font-size: smaller;padding: 1.25rem;">
        <el-tag class="mx-1" effect="dark" style="height:2.5rem;font-size: 1.6rem;">
            友情链接
        </el-tag>
        <el-divider border-style="dotted" style="margin: 0;padding: 0;" />
        <el-divider border-style="dashed" style="margin: 0;padding: 0;" />
        <div style="margin-top: 1rem;margin-bottom: 1rem;display: flex;" id="conn-div01">
            <div style="flex-grow: 1;">
                <el-icon><Link /></el-icon><nobr>齐鲁工大</nobr><br><br>
                <el-icon><Link /></el-icon><nobr>齐鲁工大</nobr> <wbr><nobr>计算学部</nobr><br><br>
                <el-icon><Link /></el-icon><nobr>省科学院</nobr><br><br>
            </div>
            <div style="flex-grow: 1;">
                <el-icon><Link /></el-icon><nobr>中国科学院</nobr><br><br>
                <el-icon><Link /></el-icon><nobr>中国工程院</nobr><br><br>
                <el-icon><Link /></el-icon><nobr>中国高性能<wbr>计算协会</nobr><br><br>
            </div>
            <div style="flex-grow: 1;">
                <el-icon><Link /></el-icon><nobr>中国科技部</nobr><br><br>
                <el-icon><Link /></el-icon><nobr>山东科技厅</nobr><br><br>
                <el-icon><Link /></el-icon><nobr>中国工信部</nobr><br><br>
            </div>
        </div>
    </div>
</template>
<style>
@media screen and (max-width: 40rem) 
{
    #conn-div01 .el-icon
    {
        display: none;
    }
}
</style>