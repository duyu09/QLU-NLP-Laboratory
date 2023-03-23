<template>
  <div class="container header_box">
    <div class="logo">
      <div class="img_box"><img alt="QLU OJ logo" src="@/assets/logo.png"></div>
      <div class="brand">Online Judge</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HeaderLogo"
}
</script>

<style scoped>
  .img_box{
    float: left;
  }

  img{
    width: 500px;
  }

  .logo .brand{
    color: #fff;
    font-size: 32px;
    float: left;
    padding-left: 10px;
    position: relative;
    top: 1px;
    border-left: 1px solid #eaeaea;
    margin-top: 7px;
    margin-left: 5px;
    overflow: hidden;
    line-height: 85px;
  }

</style>
