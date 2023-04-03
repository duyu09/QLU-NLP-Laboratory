<script>
import 'element-plus/dist/index.css';
export default
{
    name:'RotoGraph'
}
</script>
<template>
    <div class="block text-center" id="mainDiv">
    <el-carousel height="100%" style="background-color: white;" id="roto-el01">
        <!--
            <el-carousel-item v-for="item in 4" :key="item">
        <h3 class="small justify-center" text="2xl">{{ item }}</h3>
      </el-carousel-item>
        -->
    <el-carousel-item>
        <img src="../assets/images/rg-01.webp">
    </el-carousel-item>
    <el-carousel-item>
        <img src="../assets/images/rg-02.webp">
    </el-carousel-item>
    <el-carousel-item>
        <img src="../assets/images/rg-03.webp">
    </el-carousel-item>
    <el-carousel-item>
        <img src="../assets/images/rg-04.webp">
    </el-carousel-item>
    </el-carousel>
  </div>
</template>
<style>
#mainDiv img
{
    width:100%;
}
#roto-el01
{
    height: 18rem;
}
@media screen and (max-width: 40rem) 
{
    #roto-el01
    {
        height: 9rem;
    }
}
</style>