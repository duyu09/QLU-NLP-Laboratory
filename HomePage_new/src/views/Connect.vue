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
        <div style="margin-top: 1rem;margin-bottom: 1rem;display: flex;">
            <div style="flex-grow: 1;">
                <el-icon><Link /></el-icon>齐鲁工业大学<br><br>
                <el-icon><Link /></el-icon>齐鲁工业大学 计算机科学与技术学部<br><br>
                <el-icon><Link /></el-icon>山东省科学院<br><br>
            </div>
            <div style="flex-grow: 1;">
                <el-icon><Link /></el-icon>中国科学院<br><br>
                <el-icon><Link /></el-icon>中国工程院<br><br>
                <el-icon><Link /></el-icon>中国高性能计算协会<br><br>
            </div>
            <div style="flex-grow: 1;">
                <el-icon><Link /></el-icon>科学技术部<br><br>
                <el-icon><Link /></el-icon>山东省科学技术厅<br><br>
                <el-icon><Link /></el-icon>工业和信息化部<br><br>
            </div>
        </div>
    </div>
</template>