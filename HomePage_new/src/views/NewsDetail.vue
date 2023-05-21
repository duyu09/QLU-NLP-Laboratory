<template>
    <div >
        <page-header></page-header>
        <dynamic-menu></dynamic-menu>
        <up-img></up-img>
        <div class="route">
            <div class="bread">
                <el-breadcrumb separator="/">
                    <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
                    <el-breadcrumb-item><a href="/newslist">新闻列表</a></el-breadcrumb-item>
                    <el-breadcrumb-item v-if="newsinfo != null">{{ newsinfo.title }}</el-breadcrumb-item>
                </el-breadcrumb>
            </div>
            <div class="news-head" v-if="newsinfo != null">
                <div class="title">{{ newsinfo.title }}</div>
                <div class="date">{{ newsinfo.createTime }}</div>
            </div>
        </div>
        <div class="content" v-if="newsinfo != null">
            <v-md-preview :text="newsinfo.recordContent" style="width: 100%;"></v-md-preview>
            {{ newsid }}
        </div>
        <div class="news-change" v-if="newsinfo != null">
            <span @click="golast(newsinfo.beforeId != null)" :class="newsinfo.beforeId == null ? 'noactive' : 'active'">上一条新闻: {{
                newsinfo.beforeTitle == null ? "无" : newsinfo.beforeTitle }}</span>
            <span @click="gonext(newsinfo.afterId != null)" :class="newsinfo.afterId == null ? 'noactive' : 'active'"> 下一条新闻: {{
                newsinfo.afterTitle == null ? "无" : newsinfo.afterTitle
            }}</span>
        </div>
    </div>
    <Footer></Footer>
</template>

<script>
import PageHeader from "./PageHeader.vue";
import DynamicMenu from "./DynamicMenu.vue";
import VueMarkdown from 'vue-markdown'
import {getNewsDetail} from '../api.js'
import UpImg from "./UpImg.vue";
import Footer from './Footer.vue';
export default {
    name: "NewsDetail.vue",
    data() {
        return {
            index: this.$route.query.index,  //当前新闻索引
            newslist: [],//新闻列表
            newsid:this.$route.query.id,
            newsinfo: null  //新闻信息
        }
    },
    components: {
    PageHeader,
    DynamicMenu,
    VueMarkdown,
    UpImg,
    Footer
},
    created() {
        getNewsDetail(this.newsid)
        .then(res=>{
            console.log(res.data.data)
            this.newsinfo=res.data.data
        })

    },
    methods: {
        //回到新闻列表
        gobacklist() {
            this.$router.push("/newslist")
        },
        //回到首页
        gobackhome() {
            this.$router.push("/")
        },
        //上一条新闻
        golast(b) {
            if (b) {
                this.$router.push({
                    path:'/empty',
                    query: {
                        index: parseInt(this.index)-1,
                        router:'/newsdetail?id='+this.newsinfo.beforeId
                    }
                })
            }
            else{

            }
        },
        //下一条新闻
        gonext(b) {
            if (b) {
                this.$router.push({
                    path:'/empty',
                    query: {
                        id: this.newsinfo.afterId,
                        index: parseInt(this.index)+1,
                        router:'/newsdetail?id='+this.newsinfo.afterId
                    }
                })

            }
            else{

            }


        }
    }
}
</script>

<style scoped>
.news-change .noactive {
    color: gray;
    cursor: default;
}

.route {
    width: 100%;
    display: flex;
    justify-content: start;
    align-items: center;
    background: #f3f3f3;
    position: relative;
}

.bread {
    padding: 0 1.25rem 0 1.25rem;
    position: absolute;
    left: 0;
}

.news-head {
    display: flex;
    flex-direction: column;
    align-items: center;
    height: 15vh;
    margin: 0 auto;
}

.title {
    flex: 0.7;
    display: flex;
    font-size: 1.6rem;
    align-items: center;
}

.date {
    flex: 0.3;
    font-size: 0.8rem;
    color: #5e5e5e;
}

.news-change {
    display: flex;
    justify-content: space-between;
}

.news-change>span {
    color: #0e52a8;
    cursor: pointer;
    padding: 1.25rem;
}

.content {
    width: 100%;
    height: 300px;
    background: #0e52a8;
}

@media screen and (max-width: 40rem) {
    .pc-menu {
        display: none;
    }

    .route {
        align-items: flex-start;
    }

    .news-head {
        padding: 3.875rem 0 0 0;
    }

    .bread {
        height: 2.875rem;
        display: flex;
        align-items: center;
    }
}</style>