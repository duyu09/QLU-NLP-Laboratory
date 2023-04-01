<script>
import { RouterLink, RouterView } from 'vue-router'
import 'element-plus/dist/index.css';
export default
{
    name:'News'
}
</script>
<template>
    <div style="padding: 1.8rem;">
        <el-tag class="mx-1" effect="dark" id="news-tag01">
            新闻资讯
        </el-tag>
        <el-divider border-style="dotted" style="margin: 0;padding: 0;" />
        <el-divider border-style="dashed" style="margin: 0;padding: 0;" />
        <div style="margin-top: 2rem;margin-bottom: 2rem;">
            <div v-for="item in 4">
                <span style="font-size: 1.2rem;">第{{ item }}条新闻</span>
                <p style="color: grey; font-size: smaller;">
                    2022年华中科技大学计算机学院研究生国家奖学金答辩于10月19日下午1:00在计算机学院南一楼会议室举行，经学院研究生国家奖学金评审委员会评审，全院供10名...
                </p>
                <div style="display: flex;justify-content: end;width: 100%;">
                    <el-button type="primary" style="font-size: smaller;margin-top: 0.4rem;margin-bottom: 0.4rem;" size="small">查看更多</el-button>
                </div>
                <el-divider border-style="dotted" style="margin: 0;padding: 0;margin-bottom: 1rem;" />
            </div>
        </div>
    </div>
    
</template>
<style>
#news-tag01
{
    height:2.5rem;font-size: 1.6rem;
}
</style>