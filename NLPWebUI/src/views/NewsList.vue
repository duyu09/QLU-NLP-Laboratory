<script>
import PageHeader from "./PageHeader.vue";
import DynamicMenu from "./DynamicMenu.vue";
import { getNews } from "../api";
import UpImg from "./UpImg.vue";
import Footer from "./Footer.vue";
export default {
    name: "NewsList",
    components: {
        PageHeader,
        DynamicMenu,
        UpImg,
        Footer
    },
    data() {
        return {
            newslist: []
        }
    },
    mounted() {
        getNews()
            .then(res => {
                this.newslist = res.data.data
            })
    },
    methods: {
        goHome() {
            this.$router.push('/')
        },
        goNewsDetail(id, index) {
            this.$router.push({
                name: 'newsdetail',
                query: {
                    id: id,
                    index: index
                }
            })
        }
    }
}
</script>

<template>
    <div class="main">
        <page-header></page-header>
        <dynamic-menu></dynamic-menu>
        <div class="change">
            <up-img></up-img>
            <div class="content-part">
                <div id="newslist">
                    <div class="header">
                        <div class="title">新闻列表</div>
                        <div class="route" @click="goHome">
                            返回首页
                        </div>
                    </div>
                    <el-divider border-style="dotted" style="margin: 0;padding: 0;margin-bottom: 16px;" />
                    <div v-for="(item, index) in newslist" class="newsitem">
                        <div class="left">
                            <div style="font-size: 20.8px;font-weight: bold">{{ item.createTime.slice(0, 4) }}</div>
                            <div style="font-size: 16px">{{ item.createTime.slice(5, 10) }}</div>
                        </div>
                        <div class="right">
                            <span style="font-size: 19.2px;">第{{ index + 1 }}条新闻</span>
                            <p style="color: grey; font-size: smaller;margin: .625rem 0 .625rem 0">
                                {{ item.recordContent }}
                            </p>
                            <div style="display: flex;justify-content: end;width: 100%;">
                                <el-button type="primary" style="font-size: smaller;margin-top: 6.4px;margin-bottom: 6.4px;"
                                           size="small" @click="goNewsDetail(item.id, index)">查看详情</el-button>
                            </div>
                            <el-divider border-style="dotted" style="margin: 0;padding: 0;margin-bottom: 16px;" />
                        </div>
                    </div>
                </div>

                <!--            <div class="right-part">-->
                <!--                <div class="righttitle">-->
                <!--                    实验室要闻-->
                <!--                </div>-->
                <!--            </div>-->
            </div>        </div>

    </div>
    <Footer></Footer>
</template>

<style scoped>
.main {
    width: 100%;
    background: rgb(231,231,231);
}

.header {
    width: 100%;
    height: 6.25rem;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.title {
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 19.2px;
    background: #0045cb;
    padding: .625rem;
    box-sizing: border-box;
    color: white;
    width: 6.25rem;
    height: 3.125rem;
}

.route {
    font-size: 16px;
    color: gray;
    cursor: pointer;
}

#newslist {
    padding: 2.5rem;
    width: 80vw;
    box-sizing: border-box;
}

.newsitem {
    display: flex;
    width: 100%;
}

.left {
    color: #0e52a8;
    width: 3.75rem;
    height: 3.75rem;
    border: .0625rem solid #0e52a8;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-evenly;
    margin-right: 1.25rem;
}

.right {
    flex: 1;
}

.right-part {
    width: 20vw;
    padding: 3.125rem 1.875rem 0 .625rem;
    box-sizing: border-box;
}

.righttitle {
    width: 100%;
    height: 3.75rem;
    background: #0045cb;
    display: flex;
    color: white;
    font-size: 19.2px;
    justify-content: center;
    align-items: center;
}

.content-part {
    display: flex;
    background: white;
}
.change{
    width: 75%;
    margin: 10px auto 0
}

@media screen and (max-width: 640px) {
    #newslist {
        width: 100%;
        padding-top:0 ;
    }
    .change{
        width: 100%;
        margin: 0px auto 0
    }
    .right-part {
        display: none;
    }

}</style>