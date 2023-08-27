<template>
    <div class="main">
        <div class="change">
            <UpImg></UpImg>
            <div class="content">
                <div class="info">
                    <div class="title">团队掠影</div>
                    <el-divider>
                        <el-icon color="#0e52a8">
                            <StarFilled />
                        </el-icon>
                    </el-divider>

                    <el-row :gutter="15">
                        <el-col :span="12">
                            <el-tooltip
                                    class="box-item"
                                    effect="dark"
                                    content="图片信息"
                                    placement="bottom"
                                    show-after=300
                            >
                                <img class="grid-content" :src="url"/>
                            </el-tooltip>
                        </el-col>
                        <el-col :span="12">
                            <el-tooltip
                                    class="box-item"
                                    effect="dark"
                                    content="图片信息"
                                    placement="bottom"
                                    show-after=300
                            >
                                <img class="grid-content" :src="url"/>
                            </el-tooltip>                        </el-col>
                    </el-row>

                    <el-row :gutter="15">
                        <el-col :span="24">
                            <el-tooltip
                                    class="box-item"
                                    effect="dark"
                                    content="图片信息"
                                    placement="bottom"
                                    show-after=300
                            >
                                <img class="grid-content" :src="url"/>
                            </el-tooltip>                        </el-col>
                    </el-row>

                    <el-row :gutter="15">
                        <el-col :span="8">
                            <el-tooltip
                                    class="box-item"
                                    effect="dark"
                                    content="图片信息"
                                    placement="bottom"
                                    show-after=300
                            >
                                <img class="grid-content" :src="url"/>
                            </el-tooltip>                        </el-col>
                        <el-col :span="8">
                            <el-tooltip
                                    class="box-item"
                                    effect="dark"
                                    content="图片信息"
                                    placement="bottom"
                                    show-after=300
                            >
                                <img class="grid-content" :src="url"/>
                            </el-tooltip>                        </el-col>
                        <el-col :span="8">
                            <el-tooltip
                                    class="box-item"
                                    effect="dark"
                                    content="图片信息"
                                    placement="bottom"
                                    show-after=300
                            >
                                <img class="grid-content" :src="url"/>
                            </el-tooltip>                        </el-col>
                    </el-row>
                    <el-row :gutter="15">
                        <el-col :span="12">
                            <el-tooltip
                                    class="box-item"
                                    effect="dark"
                                    content="图片信息"
                                    placement="bottom"
                                    show-after=300
                            >
                                <img class="grid-content" :src="url"/>
                            </el-tooltip>                        </el-col>
                        <el-col :span="12">
                            <el-tooltip
                                    class="box-item"
                                    effect="dark"
                                    content="图片信息"
                                    placement="bottom"
                                    show-after=300
                            >
                                <img class="grid-content" :src="url"/>
                            </el-tooltip>                        </el-col>
                    </el-row>

                    <el-row :gutter="15">
                        <el-col :span="24">
                            <el-tooltip
                                    class="box-item"
                                    effect="dark"
                                    content="图片信息"
                                    placement="bottom"
                                    show-after=300
                            >
                                <img class="grid-content" :src="url"/>
                            </el-tooltip>                        </el-col>
                    </el-row>

                    <el-row :gutter="15">
                        <el-col :span="8">
                            <el-tooltip
                                    class="box-item"
                                    effect="dark"
                                    content="图片信息"
                                    placement="bottom"
                                    show-after=300
                            >
                                <img class="grid-content" :src="url"/>
                            </el-tooltip>                        </el-col>
                        <el-col :span="8">
                            <el-tooltip
                                    class="box-item"
                                    effect="dark"
                                    content="图片信息"
                                    placement="bottom"
                                    show-after=300
                            >
                                <img class="grid-content" :src="url"/>
                            </el-tooltip>                        </el-col>
                        <el-col :span="8">
                            <el-tooltip
                                    class="box-item"
                                    effect="dark"
                                    content="图片信息"
                                    placement="bottom"
                                    show-after=300
                            >
                                <img class="grid-content" :src="url"/>
                            </el-tooltip>                        </el-col>
                    </el-row>

                </div>
            </div>
        </div>

        <Footer></Footer>
    </div>
</template>
<script>
import DynamicMenu from './DynamicMenu.vue';
import PageHeader from './PageHeader.vue';
import { SemiSelect, StarFilled } from '@element-plus/icons-vue';
import UpImg from './UpImg.vue';
import Footer from './Footer.vue';
import { getStudentManage } from '../api'
export default {
    components: {
        DynamicMenu,
        PageHeader,
        SemiSelect,
        StarFilled,
        UpImg,
        Footer
    },
    data() {
        return {
            url:'https://www.qlu.edu.cn/_upload/tpl/09/ea/2538/template2538/images/list_banner.jpg'
        }
    },
    mounted() {
        getStudentManage()
            .then(res => {
                console.log(res.data)
            })
    }
}
</script>
<style scoped >
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
    padding: 20px;
    padding-bottom: 6.25rem;
    box-sizing: border-box;
    background: white;
}

.info {
    /*width: 80vw;*/
    margin: 0 auto;
}

.title {
    text-align: center;
    padding: 1.25rem 0 0 0;
    font-size: 1.6rem;
}

.el-row {
    margin-bottom: 10px;
}

.el-row:last-child {
    margin-bottom: 0;
}

.el-col {
    border-radius: 4px;
}
.el-col:last-child {
    margin-right: 0px;
}

.grid-content {
    min-height: 36px;
}
.change{
    width: 75%;
    margin: 10px auto 0;

}

@media screen and (max-width: 40rem) {
    .info {
        width: 90vw;
    }
    .change{
        width: 100%;
        margin: 0px auto 0
    }

}</style>