<template>
    <div class="main">
        <PageHeader></PageHeader>
        <DynamicMenu></DynamicMenu>
        <div class="change">
            <UpImg></UpImg>
            <div class="content">
                <div class="info" v-for="item in list">
                    <div class="title">{{item.title}}</div>
                    <el-divider>
                        <el-icon color="#0e52a8"><StarFilled/></el-icon>
                    </el-divider>
                    <v-md-preview :text="item.recordContent"></v-md-preview>
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
import {getStudentCultivation} from '../api'
export default {
    components: {
    DynamicMenu,
    PageHeader,
    SemiSelect,
    StarFilled,
    UpImg,
    Footer
},
data(){
    return{
        list:[],
    }
},
mounted(){
    getStudentCultivation()
    .then(res=>{
        console.log(res.data)
        this.list=res.data.rows
    })
}
}
</script>
<style scoped >
.main {
    width: 100%;
    background: rgb(231,231,231);
}
.upimg{
    width: 100%;
}
img{
    width: 100%;
}
.content{
    width: 100%;
    padding: 20px;
    padding-bottom: 6.25rem;
    box-sizing: border-box;
    background: white;
}
.info{
    /*width: 80vw;*/
    margin: 0 auto;
}

.title{
    text-align: center;
    padding: 1.25rem 0 0 0;
    font-size: 1.6rem;
}
.change{
    width: 75%;
    margin: 10px auto 0
}

@media screen and (max-width: 40rem)
{
    .info{
        width: 90vw;
    }
    .change{
        width: 100%;
        margin: 0px auto 0
    }
}
</style>