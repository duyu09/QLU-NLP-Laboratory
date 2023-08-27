<template>
    <div class="main">
        <div class="change">
            <UpImg></UpImg>
            <div class="content">
                <div class="info">
<!--                    标题-->
                    <div class="title">在读学生</div>

                    <el-divider content-position="left">
                    </el-divider>
<!--                    列表内容-->
                    <div class="list">
                        <div class="content-item">
                            <div class="content-img" @click="visible=true">
                                <img src="@/assets/images/gate.jpg">
                            </div>
                            <div class="content-info">
                                <div  style="font-size: large;color:black;margin:4px 0 4px 0">王。。</div>
                                <div class="info-item">2020级</div>
                                <div class="info-item">神经网络</div>
                                <div class="info-item">联系方式</div>
                            </div>
                        </div>

                        <div class="content-item">
                            <div class="content-img" @click="visible=true">
                                <img src="@/assets/images/gate.jpg">
                            </div>
                            <div class="content-info">
                                <div  style="font-size: large;color:black;margin:4px 0 4px 0">王。。</div>
                                <div class="info-item">2020级</div>
                                <div class="info-item">神经网络</div>
                                <div class="info-item">联系方式</div>
                            </div>
                        </div>

                    </div>
<!--                    弹出框-->
                    <el-dialog v-model="visible" :show-close="false">
                        <template #header="{ close, titleId, titleClass }">
                            <div style="display: flex;flex-direction: row;justify-content: space-between;">
                                <h4 :id="titleId" :class="titleClass">王。。的基本信息</h4>
                                <el-button type="danger" @click="close">
                                    <el-icon class="el-icon--left"><CircleCloseFilled /></el-icon>
                                    Close
                                </el-button>
                            </div>
                        </template>
                        <div class="detail-img">
                            <img src="@/assets/images/gate.jpg">
                        </div>
                        <div class="detail-info">
                            <div class="detail-info-item">
                                姓名: {{studentname}}
                            </div>
                            <div class="detail-info-item">
                                年级: {{studentgrade}}
                            </div>
                            <div class="detail-info-item">
                                专业: {{studentmajor}}
                            </div>
                        </div>
                    </el-dialog>

                </div>

            </div>
        </div>
        <Footer></Footer>
    </div>
</template>

<script>
    import DynamicMenu from "./DynamicMenu.vue";
    import PageHeader from "./PageHeader.vue";
    import {SemiSelect, StarFilled,CircleCloseFilled} from "@element-plus/icons-vue";
    import UpImg from "./UpImg.vue";
    import Footer from "./Footer.vue";

    export default {
        name: "TeamMember",
        components:{
            DynamicMenu,
            PageHeader,
            SemiSelect,
            StarFilled,
            CircleCloseFilled,
            UpImg,
            Footer
        },
        data(){
            return{
                visible:false,
                studentname:"王。。",
                studentgrade:"2020",
                studentmajor:"深度神经网络"
            }
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
        height: 100%;
        object-fit: cover;
    }

    .content {
        width: 100%;
        padding-bottom: 6.25rem;
        background: white;
    }

    .info {
        /*width: 80vw;*/
        margin: 0 auto;
        padding: 20px;
    }
    .list{
        display: flex;
    }
    .content-item{
        display: flex;
        flex-direction: column;
        width: 22%;
        height: 18rem;
        margin: 0 20px 20px 0;
    }
    .content-img{
        width: 100%;
        height: 12rem;
        border-radius: 10px;
        overflow: hidden;
        border:2px solid #aaaaaa;
        box-sizing: border-box;
        cursor: pointer;
    }
    .detail-img{
        width: 12rem;
        height: 12rem;
        overflow: hidden;
        border-radius: 10px;
        border:2px solid #aaaaaa;
    }
    .detail-info{
        display: flex;
        flex-direction: column;
        padding: 10px;
    }
    .detail-info-item{
        margin: 10px 0;

    }
    .content-info{
        flex: 1;
        width:100%;
        display: flex;
        flex-direction: column;
    }
    .info-item{
        margin: 0 0 4px 0;
        font-size: 0.9rem;
        color: #5f5f5f;
    }
    .title {
        /*text-align: center;*/
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
        .content-1{
            display: flex;
            flex-direction: column;
        }
        .content-left{
            padding: 0;
        }
        .content-right>p{
            font-size: 0.8rem;
        }
        .content-right{
            margin-top: 5px;
        }
    }
</style>