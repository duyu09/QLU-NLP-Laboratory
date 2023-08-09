<template>
    <div class="main">
        <PageHeader></PageHeader>
        <DynamicMenu></DynamicMenu>
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
                        <img class="grid-content ep-bg-purple" :src="url"/>
                    </el-col>
                    <el-col :span="12">
                        <img class="grid-content ep-bg-purple-light" :src="url"/>
                    </el-col>
                </el-row>

                <el-row :gutter="15">
                    <el-col :span="24">
                        <img class="grid-content ep-bg-purple-dark" :src="url"/>
                    </el-col>
                </el-row>
                
                <el-row :gutter="15">
                    <el-col :span="8">
                        <img class="grid-content ep-bg-purple" :src="url"/>
                    </el-col>
                    <el-col :span="8">
                        <img class="grid-content ep-bg-purple-light" :src="url"/>
                    </el-col>
                    <el-col :span="8">
                        <img class="grid-content ep-bg-purple" :src="url"/>
                    </el-col>
                </el-row>
                <el-row :gutter="15">
                    <el-col :span="12">
                        <img class="grid-content ep-bg-purple" :src="url"/>
                    </el-col>
                    <el-col :span="12">
                        <img class="grid-content ep-bg-purple-light" :src="url"/>
                    </el-col>
                </el-row>

                <el-row :gutter="15">
                    <el-col :span="24">
                        <img class="grid-content ep-bg-purple-dark" :src="url"/>
                    </el-col>
                </el-row>
                
                <el-row :gutter="15">
                    <el-col :span="8">
                        <img class="grid-content ep-bg-purple" :src="url"/>
                    </el-col>
                    <el-col :span="8">
                        <img class="grid-content ep-bg-purple-light" :src="url"/>
                    </el-col>
                    <el-col :span="8">
                        <img class="grid-content ep-bg-purple" :src="url"/>
                    </el-col>
                </el-row>

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
}

.info {
    width: 80vw;
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

@media screen and (max-width: 40rem) {
    .info {
        width: 90vw;
    }
}</style>