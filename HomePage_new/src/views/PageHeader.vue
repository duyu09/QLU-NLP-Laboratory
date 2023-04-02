<script>
import { RouterLink, RouterView } from 'vue-router'
export default
{
    name:'PageHeader'
}
</script>
<template>
  <div id="d01">
        <div id="shortname" style="display: none;font-size: 1.8rem">QLU NLP
            <span style="font-size: 1rem;display:inline-block;height: 1rem">Laboratory</span>
        </div>
        <div id="headTitle01">
          <span><nobr>齐鲁工业大学</nobr></span>
        </div>
        <div id="headTitle02">
            自然语言处理实验室<br>
            <span style="font-size: smaller;color: rgb(120,255,255);"><nobr>Laboratory of Natural </nobr><wbr><nobr>Language Processing</nobr></span>
        </div>
        <div id="headTitle03"></div>
      <slot></slot>
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
  @media screen and (max-width: 40rem) 
  {
    #d01
    {
      background-image: linear-gradient(to right,rgb(16,83,151),rgb(16,83,151));
        padding-left: 0;
        display: flex;
        justify-content: center;
    }
    #headTitle01
    {
        display: none;
        margin-left: 0;
        padding:0;
        font-size: 1.6rem;
        flex-grow: 0;
    }
    #headTitle02
    {
        display: none;
    }
    #headTitle03{
        flex-grow: 0;
    }
    #shortname{
        display: inline !important;
        position: absolute;
        left: 2rem;
    }
  }
</style>
