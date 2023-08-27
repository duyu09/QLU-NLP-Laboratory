<template>
    <div class="main">
        <div class="change">
            <UpImg></UpImg>
            <div class="content">
                <div class="info">
                    <div class="title">专利</div>
                    <el-divider>
                        <el-icon color="#0e52a8">
                            <StarFilled />
                        </el-icon>
                    </el-divider>
                    <div class="content-1">
                        <ul>
                            <li>大大大</li>
                            <li>发发发</li>
                        </ul>
                    </div>
                </div>



            </div>
        </div>
        <Footer></Footer>
    </div>
</template>

<script>
    import DynamicMenu from "./DynamicMenu.vue";
    import PageHeader from "./PageHeader.vue";
    import {SemiSelect, StarFilled} from "@element-plus/icons-vue";
    import UpImg from "./UpImg.vue";
    import Footer from "./Footer.vue";

    export default {
        name: "ResearchResult",
        components:{
            DynamicMenu,
            PageHeader,
            SemiSelect,
            StarFilled,
            UpImg,
            Footer
        }
    }
</script>

<style scoped>
    .main {
        width: 100%;
        background: rgb(231,231,231);
        overflow: hidden;
    }

    .upimg {
        width: 100%;
    }

    img {
        width: 100%;
    }

    .content {
        width: 100%;
        padding-bottom: 6.25rem;
        background: white;
    }
    .content-1{
        padding-left: 20px;
    }
    .content-1>ul li::marker{
        color: #0ea5de;
        font-size: 1.4rem;
    }
    .info {
        /*width: 80vw;*/
        margin: 0 auto;
        padding: 20px;
    }

    .title {
        text-align: center;
        padding: 1.25rem 0 0 0;
        font-size: 1.6rem;
    }
    .change{
        width: 75%;
        margin: 10px auto 0;
    }


    @media screen and (max-width: 40rem) {
        .info{
            width: 90vw;
        }
        .change{
            width: 100%;
            margin: 0px auto 0
        }


    }
</style>