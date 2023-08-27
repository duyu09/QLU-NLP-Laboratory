<script>
import { RouterLink, RouterView } from 'vue-router'
import 'element-plus/dist/index.css';
import {getNews} from "../api";
export default
{
    name:'News',
    data(){
        return{
            newslist:[]
        }
    },
    mounted() {
        getNews()
        .then(res=>{
            console.log("新闻列表",res.data.data)
            this.newslist=res.data.data.slice(0,2)
        })
    },
    methods:{
        //去新闻列表
        goNewsList(){
            this.$router.push("/newslist")
        },
        //去新闻详情
        goNewsDetail(id,index){
            console.log("去第"+index+1+"条新闻")
            this.$router.push({
                name:'newsdetail',
                query:{
                    id:id,
                    index:index
                }
            })
        }

    }
}
</script>
<template>
    <div id="news-mainDiv">
        <el-tag class="mx-1" effect="dark" id="news-tag01">
            新闻资讯
        </el-tag>
        <div id="news-more" @click="goNewsList">
            MORE>
        </div>
        <el-divider border-style="dotted" style="margin: 0;padding: 0;" />
        <el-divider border-style="dashed" style="margin: 0;padding: 0;" />
        <div id="news-div02">
            <div v-for="(item,index) in newslist">
                <span style="font-size: 1.2rem;">{{ item.title }}</span>
                <p style="color: grey; font-size: smaller;margin-top: 5px">
                    {{item.synopsisContent}}
                </p>
                <div class="news-img">
                    <img src="@/assets/images/gate.jpg">
                </div>

                <div style="display: flex;justify-content: start;width: 100%;">
                    <div style="color: gray;font-size: 0.8rem">{{item.createTime}}</div>
                </div>

                <div style="display: flex;justify-content: end;width: 100%;">
                    <el-button type="primary" style="font-size: smaller;margin-top: 0.4rem;margin-bottom: 0.4rem;" size="small" @click="goNewsDetail(item.id,index)">查看更多</el-button>
                </div>
                <el-divider border-style="dotted" style="margin: 0;padding: 0;margin-bottom: 1rem;" />
            </div>
        </div>
    </div>
    
</template>
<style>
    img{
        width: 100%;
        height: 100%;
    }
    .news-img{
        width: 17rem;
        margin: 10px 0 10px 0;
    }
#news-mainDiv
{
    padding: 1.8rem;padding-top: 1.25rem;
    position: relative;
}
#news-div02
{
    margin-top: 2rem;margin-bottom: 2rem;
}
#news-tag01
{
    height:2.5rem;font-size: 1.6rem;
}
    #news-more{
        color: #0ea5de;
        font-size: 1rem;
        float: right;
        cursor: pointer;
    }
</style>