<template>
    <div class="main">
        <PageHeader></PageHeader>
        <DynamicMenu></DynamicMenu>
        <div class="change">
            <UpImg></UpImg>
            <div class="content">
                <div class="info">
                    <div class="title">在读学生</div>
                    <el-divider>
                        <el-icon color="#0e52a8">
                            <StarFilled />
                        </el-icon>
                    </el-divider>
                    <el-table :data="tableData" stripe style="width: 100%" :fit="true" :scrollbar-always-on="false">
                        <el-table-column prop="date" label="姓名"  />
                        <el-table-column prop="name" label="性别"  />
                        <el-table-column prop="address" label="年级" />
                        <el-table-column prop="address" label="学历" />
                    </el-table>
                </div>


                <div class="info">
                    <div class="title">毕业生</div>
                    <el-divider>
                        <el-icon color="#0e52a8">
                            <StarFilled />
                        </el-icon>
                    </el-divider>
                    <el-table :data="tableData" stripe style="width: 100%" :fit="true" :scrollbar-always-on="false">
                        <el-table-column prop="date" label="姓名"  />
                        <el-table-column prop="name" label="性别"  />
                        <el-table-column prop="address" label="年级" />
                        <el-table-column prop="address" label="学历" />
                    </el-table>
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
            tableData : [
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-02',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-04',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
]
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