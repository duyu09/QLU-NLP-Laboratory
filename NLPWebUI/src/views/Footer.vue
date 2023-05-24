<script>
import { RouterLink, RouterView } from 'vue-router'
import 'element-plus/dist/index.css';
export default
{
    name:'Footer'
}
</script>
<template>
    <div id="footDiv">
        <div>
            <div style="display: flex;">
                <div id="div01">
                地址：山东省济南市大学路3501号 <br>齐鲁工业大学(长清校区)机电楼A座411室<br>
                邮编：250000<br>
                </div>
                <div id="div02">
                联系人：鹿老师<br>
                联系电话：10000000000<br>
                邮箱：example@qq.com
                </div>
            </div>
        </div>
    </div>
</template>
<style>
*
  {
   margin: 0;
   padding: 0;
  }
  #footDiv
  {
    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei', '微软雅黑', Arial, sans-serif;
    background-color: rgb(16,83,151);
    color: white;
    height: 6.6rem;
    padding-top: 1.4rem;
  }
  #div01
  {
    border-right: .125rem solid white;
    flex-grow: 1;
    padding-left: 6rem;
    padding-right: 0rem;
  }
  #div02
  {
    flex-grow: 1;
    justify-content: center;
    padding-left: 2rem;
  }
  @media screen and (max-width: 40rem)
  {
    #div01
    {
        font-size: smaller;
        padding-left: 1.8rem;
        padding-right: 0rem;
        border-right:0px;
    }
    #div02
    {
        font-size: smaller;
        display: none;
    }
  }
</style>