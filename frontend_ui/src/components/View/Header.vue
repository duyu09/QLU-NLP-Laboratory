<template>
  <div class="train_head">
    <!-- 标题 -->
    <div class="train_title_box">
      <p class="train_title"><span style="cursor:pointer;" @click="toUrlPath(headerTitleUrl)">{{ headerTitle }}</span></p>
      <Menu></Menu>
<!--      <div>-->
<!--        <el-button-->
<!--          v-if="name.length === 0"-->
<!--          @click="toLoginPath"-->
<!--          type="primary"-->
<!--          plain-->
<!--          style="width: 80%"-->
<!--        >登 录 / 注 册</el-button-->
<!--        >-->
<!--        <el-dropdown v-else :hide-on-click="false">-->
<!--        <span class="el-dropdown-link" style="font-size: 18px">-->
<!--          用户：{{ name }}-->
<!--        </span>-->
<!--          <template #dropdown>-->
<!--            <el-dropdown-menu>-->
<!--              <el-dropdown-item @click="toProfile">-->
<!--                <span>个人中心</span>-->
<!--              </el-dropdown-item>-->
<!--              <el-dropdown-item @click="loginOut">-->
<!--                <span>退出登录</span>-->
<!--              </el-dropdown-item>-->
<!--            </el-dropdown-menu>-->
<!--          </template>-->
<!--        </el-dropdown>-->
<!--      </div>-->
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import Menu from "@/components/View/Menu";
import HeaderLogo from "@/components/View/HeaderLogo";

export default {
  name: "Header",
  components: {HeaderLogo, Menu },
  props: {
    //  标题
    title: {
      type: String,
      default: "",
    },
    //  路由地址
    url: {
      type: String,
      default: "",
    },
  },
  data() {
    return {
      //title
      headerTitle: this.title,
      headerTitleUrl: this.url,
    };
  },
  computed: {
    ...mapGetters(["name"]),
  },
  methods: {
    // 跳转登录页面
    toLoginPath() {
      this.$router.push({ path: "/login", query: { redirect: "/index" } });
    },
    // 跳转登录页面
    toProfile() {
      const { href } = this.$router.resolve({
        path: "/profile/index",
      });
      window.open(href, "_blank");
    },
    toUrlPath(url) {
      window.location.href = url;
    },
    // 退出登录
    loginOut() {
      this.$confirm("确定退出系统吗？", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.$store.dispatch("LogOut").then(() => {
            location.href = "/index";
          });
        })
        .catch(() => {});
    },
  },
};
</script>

<style scoped lang="scss">
// 标题
.train_head {
  background-color: #f8f8f8;

  .train_title_box {
    margin: 0 auto;
    display: grid;
    grid-template-columns: 40% 60%;
    justify-content: end;
    align-items: center;

    .train_title {
      width: 100%;
      font-weight: 700;
      font-size: 27px;
      color: #73767a;
      padding: 10px 0;
      margin: 0;
      text-align: center;
      user-select: none;
    }

    // 登录按钮
    .train_login_button {
      width: 100%;
      padding-right: 5px;
      font-size: 18px;
      font-weight: bold;
      color: #73767a;
      background: none;
      cursor: pointer;
    }
    .train_login_button:hover {
      color: #800080;
    }

    .el-dropdown-link {
      font-size: 18px;
      cursor: pointer;
      user-select: none;
    }
    .el-dropdown-link:hover {
      color: #73767a;
    }
  }
}
</style>
