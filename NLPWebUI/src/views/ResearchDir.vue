<template>
    <div class="main">
        <div class="change">
            <UpImg></UpImg>
            <div class="content">
                <div class="info">
                    <div class="title">方向1</div>
                    <el-divider>
                        <el-icon color="#0e52a8">
                            <StarFilled />
                        </el-icon>
                    </el-divider>
                    <div class="content-1">
                        <div class="content-left">
                            <img src="@/assets/images/gate.jpg">
                        </div>
                        <div class="content-right">
                            <p>
                                主要研究如何使计算机有效处理和理解人类自然语言的相关基础理论和分析方法，其是当前人工智能领域在认知智能层面解决人机交互需要重点突破和解决的核心难点问题之一，其研究涵盖：自然语言处理基础理论（如分词、句法分析、语义理解、篇章分析、指代消歧等）、机器翻译、信息抽取与过滤、信息检索、知识表示与推理、多源异质文本数据分析与挖掘等。本方向是计算机科学、语言学、数学、逻辑学、认知科学等多学科领域的交叉方向，通过将自然语言处理与云计算、社交计算、物联网等相关领域研究进行深度融合，为人工智能与大数据处理技术在医疗、电子政务、互联网金融等相关行业方面的应用落地提供重要技术支撑，从而有效推动我国信息领域科学技术进步与中文信息处理产业发展。
                                成果展示：
                                自然语言工具包(Hust-NLP)
                                智能对话机器人---小希（取CCIIP首字母谐音）
                            </p>
                        </div>
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
        name: "ResearchDir",
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
        height: 100%;
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
    .content-1{
        display: flex;
    }
    .content-left{
        flex:0.5;
        padding-right: 20px;
    }
    .content-right{
        flex:0.5;
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