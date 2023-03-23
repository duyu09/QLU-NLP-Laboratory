<template>
  <el-menu :default-active="activeIndex" class="el-menu-vertical-demo">
    <el-menu-item
      :index="item.id"
      v-for="(item, index) in userPages"
      :key="index"
      @click="pageShow(item.id)"
    >
      <span style="font-size: 18px; font-weight: bold">{{ item.name }}</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
export default {
  name: "ProfileMenu",
  data() {
    return {
      // 默认显示页面
      activeIndex: "1",
      // 导航使用元素数据
      userPages: [
        {
          id: "1",
          icon: "el-icon-star-on",
          name: "个人主页",
          path: "/profile/index",
        },
        {
          id: "2",
          name: "题目推荐",
          path: "/profile/recommend",
        },
        {
          id: "3",
          name: "交题历史",
          path: "/profile/submit",
        },
        {
          id: "4",
          name: "个性分析",
          path: "/profile/analyse",
        },
      ],
    };
  },
  // 路由变化
  watch: {},
  created() {
    // 实现路由访问
    for (const i in this.userPages) {
      if (this.$route.path === this.userPages[i].path) {
        this.activeIndex = this.userPages[i].id;
      }
    }
  },
  methods: {
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
