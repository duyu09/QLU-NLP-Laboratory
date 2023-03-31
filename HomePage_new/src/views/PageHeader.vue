<script>
import { RouterLink, RouterView } from 'vue-router'
export default
{
    name:'PageHeader'
}
</script>
<template>
  <div id="d01">
        <div id="headTitle01">
          <span>齐鲁工业大学</span>
        </div>
        <div id="headTitle02">
            自然语言处理实验室<br>
            <span style="font-size: smaller;color: rgb(120,255,255);">Laboratory of Natural Language Processing</span>
        </div>
        <div id="headTitle03"></div>
  </div>
</template>
<style>
  *
  {
   margin: 0;
   padding: 0;
  }
  #d01
  {
    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei', '微软雅黑', Arial, sans-serif;
    background-image: linear-gradient(to right, rgb(0, 204, 204), rgb(0, 0, 204));
    color: white;
    height: 6.7rem;
    padding-top: 1.3rem;
    display: flex;
  }
  #headTitle01
  {
    font-size: 3.2rem;
    margin-left: 5rem;
    flex-grow: 2;
  }
  #headTitle02
  {
    flex-grow: 13;
    font-size: 1.4rem;
    font-style: italic;
    margin-top: 0.8rem;
  }
  #headTitle03
  {
    flex-grow: 8;
  }
</style>
