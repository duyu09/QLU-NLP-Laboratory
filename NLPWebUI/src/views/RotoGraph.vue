<script>
import 'element-plus/dist/index.css';
import {getRotoGraphHttp} from "../api";

export default
{
    name:'RotoGraph',
    data()
    {
      return{
        baseURL:import.meta.env.VITE_BASE_URL,
        rotoGraphList:null,
        diaVisible:false,
        diaContext:'',
      }
    },
    mounted()
    {
        getRotoGraphHttp().then(res=>{
          this.rotoGraphList=res.data.data
        });
    },
    methods:{
      Jump(i)
      {
        const flag = i.isFrame
        if(flag==='0')
        {
          window.location="http://"+i.urlPath;
        }
        else
        {
          // marked(i.recordContent).then(
          //     res=>{this.diaContext=res;}
          // );
          console.log(i.recordContent)
          this.diaContext = i.recordContent;
          this.diaVisible=true;
        }
      }
    }
}
</script>
<template>
    <div class="block text-center" id="mainDiv">
    <el-carousel height="100%" style="background-color: white;" id="roto-el01">
    <el-carousel-item v-for="i in rotoGraphList">
        <img :src=this.baseURL+i.carouselImg @click.native="Jump(i)" style="height: 100%;">
    </el-carousel-item>
<!--    <el-carousel-item>-->
<!--        <img src="../assets/images/002.jpg">-->
<!--    </el-carousel-item>-->
<!--    <el-carousel-item>-->
<!--        <img src="../assets/images/rg-03.webp">-->
<!--    </el-carousel-item>-->
<!--    <el-carousel-item>-->
<!--        <img src="../assets/images/rg-04.webp">-->
<!--    </el-carousel-item>-->
    </el-carousel>
  </div>
  <el-dialog v-model="diaVisible" title="详细信息">
<!--    {{ diaContext }}-->
    <v-md-preview :text="diaContext"></v-md-preview>
  </el-dialog>
</template>
<style>
#mainDiv img
{
  width:100%;
}
#roto-el01
{
  height: 18rem;
  cursor: pointer;
}
@media screen and (max-width: 40rem)
{
  #roto-el01
  {
    height: 9rem;
  }
}
</style>
