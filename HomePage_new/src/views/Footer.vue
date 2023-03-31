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
        <div style="margin-left: 6rem;">
            <div style="display: flex;">
                <div style="flex-grow: 1;">
                地址：山东省济南市大学路3501号 <br>齐鲁工业大学(长清校区)机电楼A座411室<br>
                邮编：250000<br>
                </div>
                <div style="flex-grow: 1;">
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
    background-image: linear-gradient(to right, rgb(0, 204, 204), rgb(0, 0, 204));
    color: white;
    height: 6.6rem;
    padding-top: 1.4rem;
  }
</style>