<script>
  import DynamicMenu from "@/views/DynamicMenu.vue";
  import PageHeader from "@/views/PageHeader.vue";

  export default {
    components:{
      DynamicMenu,
      PageHeader,
    }
  }
</script>
<template>
  <PageHeader></PageHeader>
  <DynamicMenu></DynamicMenu>
  <router-view>

  </router-view>
</template>
<style>
  *{
    margin: 0;
    padding: 0;
  }
  html,body{
    height: 100%;
    width: 100%;
  }
</style>