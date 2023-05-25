<script>
import DynamicMenu from "./DynamicMenu.vue";
import PageHeader from "./PageHeader.vue";
import UpImg from "./UpImg.vue";

export default
{
  name: "TeacherPage",
  components: {
    DynamicMenu,
    PageHeader,
    UpImg,
  },
}
</script>

<template>
 <div id="tp-mainDiv">
   <PageHeader></PageHeader>
   <div id="tp-div03">
     <div id="tp-div04">
       <DynamicMenu></DynamicMenu>
     </div>
   </div>
   <div id="tp-div01">
     <div id="tp-div02">
       <div id="tp-div05">
         <div id="tp-div06">
           <div id="tp-div09">
             <img src="/src/assets/images/lu.jpg" id="tp-img01" alt="">
           </div>
         </div>
         <div id="tp-div07">
           <div id="tp-div10">
             <div id="tp-div11">
               <div class="tp-cls01">
                 <table id="tp-table01">
                   <tbody>
                   <tr>
                     <td>姓名</td><td>鹿文鹏</td>
                   </tr>
                   <tr>
                     <td>性别</td><td>男</td>
                   </tr>
                   <tr>
                     <td>学历</td><td>博士研究生</td>
                   </tr>
                   <tr>
                     <td>毕业学校</td><td>北京理工大学</td>
                   </tr>
                   <tr>
                     <td>专业</td><td>计算机应用技术</td>
                   </tr>
                   <tr>
                     <td>办公室</td><td>机电楼A411</td>
                   </tr>
                   <tr>
                     <td>QQ</td><td>8027462</td>
                   </tr>
                   <tr>
                     <td>E-mail</td><td>Luwpeng@163.com</td>
                   </tr>
                   </tbody>
                 </table>
               </div>
             </div>
           </div>
         </div>
       </div>
     </div>
   </div>
   <div id="tp-div12">
     <div id="tp-div13">
       123123
     </div>
   </div>


 </div>
</template>

<style scoped>
#tp-mainDiv
{
  background-color: white;
}
#tp-div01
{
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 1.5rem;
}
#tp-div02
{
  width: 75%;
  background-color: rgb(240,240,240);
}
#tp-div03
{
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: rgb(240,240,240);
}
#tp-div04
{
  width: 75%;
}
#tp-div05
{
  display: flex;
  height: 20rem;
}
#tp-div06
{
  flex-grow: 1;
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100%;
}
#tp-div07
{
  flex-grow: 6;
  display: flex;
  justify-content: center;
  align-items: center;
  /*border-left: 1px solid black;*/
}
#tp-img01
{
  background-size: contain;
  height: 100%;
  width: auto;
  border-radius: 10px;
  box-shadow: grey 0.2rem 0.2rem 9px 1px;
}
#tp-div09
{
  height: 90%;
  width: auto;
}
#tp-div10
{
  background-color: white;
  width:87.5%;
  height :92.5%;
  border-radius: 10px;
  box-shadow: grey 0 0 9px 1px;
}
#tp-div11
{
  margin-left: 1.25rem;
  margin-right: 1.25rem;
  padding-top: 0.75rem;
}
.tp-cls01
{
  /*margin-top: 0.75rem;*/
}
#tp-table01
{
  width: 100%;
  border-collapse: separate;
  border-spacing: 0.6667rem; /* 调整行间距的数值 */
}
#tp-div12
{
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 1.5rem;
}
#tp-div13
{
  width:75%;
  background-color: rgb(240,240,240);
}

</style>
