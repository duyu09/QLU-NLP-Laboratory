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
    background-image: linear-gradient(to right, rgb(0,251,255), rgb(0,1,255));
    color: white;
    height:6.1875rem;
    padding-top: 0rem;
    display: flex;
    align-items: center;
    padding-left: 1.25rem;
  }
  @media screen and (min-width: 50rem) {
    #d01{
      background-color: rgb(16,83,151);
    }
  }
  #headTitle01
  {
    font-size: 2rem;
    line-height: 2rem;
    margin-left: 5.5rem;
    flex-grow: 2;
  }
  #headTitle02
  {
    flex-grow: 13;
    font-size: 1rem;
    font-style: italic;
    margin-top: 0;
  }
  #headTitle03
  {
    flex-grow: 8;
  }
</style>
