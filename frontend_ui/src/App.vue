<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <HeaderLogo/>
      </el-header>
      <Header title="QLUOJ" url="https://icpc.qlu.edu.cn/"></Header>
      <el-main v-bind:style="{ minHeight: Height + 'px' }">
        <div class="container">
          <router-view />
        </div>
      </el-main>
      <el-footer>
        <Footer></Footer>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import Header from "@/components/View/Header";
import Footer from "@/components/View/Footer";
import HeaderLogo from "@/components/View/HeaderLogo";
export default {
  components: {HeaderLogo, Footer, Header },
  data() {
    return {
      Height: 0,
    };
  },
  mounted() {
    // 动态设置内容高度 让footer始终居底   header+footer的高度是175
    this.Height = document.documentElement.clientHeight - 235;
    // 监听浏览器窗口变化
    window.onresize = () => {
      this.Height = document.documentElement.clientHeight - 235;
    };
  },
};
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

body {
  margin: 0;
}

// 修改组件默认样式
.common-layout {
  background-color: #e7e7e7;
  margin: 0 auto;
}

.common-layout .el-header {
  padding: 0;
  height: 100px;
}

.common-layout .el-main {
  padding-bottom: 0;
}

.common-layout .el-footer {
  padding: 0;
}

.container {
  max-width: 80%;
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;
}

.el-header{
  background-image: linear-gradient(to right, cyan , blue);
  margin-bottom: 0;
  border: medium none;
}

.el-main .container{
  padding: 25px 15px 20px;
  background-color: #FFF;
}

.chq_body {
  padding: 0 30px;
  background-color: #FFF;
}

@media screen and (min-width: 1261px) {
  //各个主要显示的控制
  .container {
    max-width: 78%;
  }

  //网站头的控制
  Header {
    display: block;
  }

  // menu 组价控制
  .windows-box {
    display: block;
  }
  .mobile-box {
    display:none;
  }
  .mobile-btn {
    display:none;
  }

  // 人物志界面的控制
  .index_main {
    flex-direction: row;
  }
  .right_card {
    width: 23%;
    padding: 10px 5px;
  }

  // 视频界面的控制

  // 公告界面的控制 Domjudge + ICPC私云

  // 训练题集界面控制
}
@media screen and (max-width: 1260px) {
  //各个主要显示的控制
  .container {
    max-width: 1200px;
  }

  //网站头的控制
  Header {
    display: block;
  }

  // menu 组价控制
  .windows-box {
    display: block;
  }
  .mobile-box {
    display:none;
  }
  .mobile-btn {
    display:none;
  }

  // 人物志界面的控制
  .index_main {
    flex-direction: row;
  }
  .right_card {
    width: 30%;
    padding: 10px 5px;
  }

  // 视频界面的控制

  // 公告界面的控制 Domjudge + ICPC私云

  // 训练题集界面控制
}
@media screen and (max-width: 992px) {
  //各个主要显示的控制
  .container {
    max-width: 960px;
  }

  //网站头的控制
  Header {
    display: block;
  }

  // menu 组价控制
  .windows-box {
    display: block;
  }
  .mobile-box {
    display:none;
  }
  .mobile-btn {
    display:none;
  }

  // 人物志界面的控制
  .index_main {
    flex-direction: row;
  }
  .right_card {
    //width: 33.33%;
  }

  // 视频界面的控制

  // 公告界面的控制 Domjudge + ICPC私云

  // 训练题集界面控制
}
@media screen and (max-width: 768px) {
  //各个主要显示的控制
  .container {
    max-width: 720px;
  }

  //网站头的控制
  Header {
    //display: none;
  }

  // menu 组价控制
  .windows-box {
    display: none;
  }
  .mobile-box {
    display:block;
  }
  .mobile-btn {
    display:block;
  }

  // 人物志主界面控制
  .index_main {
    flex-direction: column;
  }
  .right_card {
    width: 47.5%;
  }

  // 视频界面的控制

  // 公告界面的控制 Domjudge + ICPC私云

  // 训练题集界面控制
}
@media screen and (max-width: 576px) {
  //各个主要显示的控制
  .container {
    max-width: 540px;
  }

  //网站头的控制
  Header {
    //display:none;
  }

  .common-layout .el-main {
    padding: 20px 0;
  }

  // menu 组价控制
  .windows-box {
    display:none;
  }
  .mobile-box {
    display: block;
  }
  .mobile-btn {
    display:block;
  }

  // 人物志界面的控制
  .index_main {
    //flex-direction: column;
  }
  .right_card {
    width: 100%;
    padding: 10px;
  }

  // 视频界面的控制

  // 公告界面的控制 Domjudge + ICPC私云

  // 训练题集界面控制
}
</style>
