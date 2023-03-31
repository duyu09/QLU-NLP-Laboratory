<script>
import 'element-plus/dist/index.css';
export default
{
    name:'RotoGraph'
}
</script>
<template>
    <div class="block text-center" id="mainDiv">
    <el-carousel height="18rem" style="background-color: gray;">
        <!--
            <el-carousel-item v-for="item in 4" :key="item">
        <h3 class="small justify-center" text="2xl">{{ item }}</h3>
      </el-carousel-item>
        -->
    <el-carousel-item>
        <img src="../assets/images/rg-01.png">
    </el-carousel-item>
    <el-carousel-item>
        <img src="../assets/images/rg-02.png">
    </el-carousel-item>
    <el-carousel-item>
        <img src="../assets/images/rg-03.png">
    </el-carousel-item>
    <el-carousel-item>
        <img src="../assets/images/rg-04.jpg">
    </el-carousel-item>
    </el-carousel>
  </div>
</template>
<style>
#mainDiv img
{
    width:100%;
}
</style>