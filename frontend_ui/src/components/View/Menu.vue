<template>
  <el-menu
    :default-active="activeIndex"
    mode="horizontal"
    class="el-menu-vertical-demo"
    background-color="#f8f8f8"
  >
    <el-menu-item
      :index="item.id"
      v-for="(item, index) in userPages"
      :key="index"
      @click="pageShow(item.id)"
    >
      <span style="font-size: 18px; font-weight: bold">
<!--        <i :class="item.icon"></i>-->
        {{ item.name }}</span
      >
    </el-menu-item>
  </el-menu>
</template>

<script>
export default {
  name: "Menu",
  data() {
    return {
      // 默认显示页面
      activeIndex: "3",
      // 导航使用元素数据
      userPages: [
        // {
        //   id: "1",
        //   icon: "el-icon-star-on",
        //   name: "个人主页",
        //   path: "/profile/index",
        // },
        {
          id: "1",
          icon: "el-icon-star-on",
          name: "赛事列表",
          path: "/contests",
        },
        {
          id: "2",
          icon: "el-icon-s-custom",
          name: "人物志",
          path: "/characters",
        },
        // {
        //   id: "3",
        //   name: "首页",
        //   path: "/index",
        // },
        // {
        //   id: "4",
        //   name: "home",
        //   path: "/home",
        // },
        {
          id: "3",
          icon: "el-icon-s-data",
          name: "DomJudge",
          path: "/domjudge",
        },
        {
          id: "4",
          icon: "el-icon-video-camera-solid",
          name: "视频课程",
          path: "/course",
        },
        {
          id: "5",
          icon: "el-icon-s-order",
          name: "训练题集",
          path: "/collection",
        },
        {
          id: "6",
          icon: "el-icon-upload",
          name: "ICPC私云",
          path: "/cloud",
        },
      ],
    };
  },
  // 路由变化
  watch: {
    '$route':'getPath'
  },
  created() {
    // 实现路由访问
    for (const i in this.userPages) {
      if (this.$route.path === this.userPages[i].path) {
        this.activeIndex = this.userPages[i].id;
      }
    }
  },
  methods: {
    // 监听路由变化
    getPath() {
      for (const i in this.userPages) {
        if((this.$route.path) === this.userPages[i].path){
          this.activeIndex = this.userPages[i].id
          break
        } else {
          this.activeIndex = 0
        }
      }
    },
    // 切换导航页面功能实现
    pageShow: function (index) {
      this.activeIndex = index;
      if (this.$router.currentRoute.path !== this.userPages[index - 1].path) {
        this.$router.push(this.userPages[index - 1].path);
      }
    },
  },
  mounted() {},
};
</script>

<style scoped></style>
