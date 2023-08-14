<script>
import PageHeader from "./PageHeader.vue";
import DynamicMenu from "./DynamicMenu.vue";
import { getAcademicResource, getNews } from "../api";
import Footer from './Footer.vue';
import UpImg from "./UpImg.vue";
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
            resourcelist: []
        }
    },
    mounted() {
        getAcademicResource()
            .then(res => {
                console.log(res.data)
                this.resourcelist = res.data.rows
            })
    },
    methods: {
        goHome() {
            this.$router.push('/')
        },
        goResourceDetail(url) {
            window.location.href="http://"+url
        }
    }
}
</script>

<template>
    <div class="main">
        <page-header></page-header>
        <dynamic-menu></dynamic-menu>
        <div class="change">
            <UpImg></UpImg>
            <div class="content-part">
                <div id="newslist">
                    <div class="header">
                        <div class="title">学术资源</div>
                        <div class="route" @click="goHome">
                            返回首页
                        </div>
                    </div>
                    <el-divider border-style="dotted" style="margin: 0;padding: 0;margin-bottom: 16px;" />
                    <div v-for="(item, index) in resourcelist" class="newsitem">
                        <div class="left">

                        </div>
                        <div class="right">
                            <span style="font-size: 19.2px;">{{ item.recourceName }}</span>
                            <p style="color: grey; font-size: smaller;margin: .625rem 0 .625rem 0">
                                {{ item.recordContent }}
                            </p>
                            <div style="display: flex;justify-content: end;width: 100%;">
                                <el-button type="primary" style="font-size: smaller;margin-top: 6.4px;margin-bottom: 6.4px;"
                                           size="small" @click="goResourceDetail(item.recourceUrl)">查看详情</el-button>
                            </div>
                            <el-divider border-style="dotted" style="margin: 0;padding: 0;margin-bottom: 16px;" />
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <Footer></Footer>
    </div>
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
    border: .5rem solid #0e52a8;
    height: 0;
    width: 0;
    border-radius: 50%;
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
    padding-bottom: 6.25rem;
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