import router from "./router";
import store from "./store";
import { ElMessage } from "element-plus";
import { getToken } from "./utils/auth";
import NProgress from "nprogress";

NProgress.configure({ showSpinner: false });

// const whiteList = ["/", "/index", "/login"];

const blackList = ["/about"];

router.beforeEach((to, from, next) => {
  NProgress.start();
  if (getToken()) {
    /* has token*/
    if (to.path === "/login") {
      next({ path: "/" });
      NProgress.done();
    } else {
      if (store.getters.roles.length === 0) {
        // 判断当前用户是否已拉取完user_info信息
        store
          .dispatch("GetInfo")
          .then(() => {
            // store.dispatch("GenerateRoutes").then((accessRoutes) => {
            //   // 根据roles权限生成可访问的路由表
            //   router.addRoutes(accessRoutes); // 动态添加可访问路由表
            next({ ...to, replace: true }); // hack方法 确保addRoutes已完成
            // });
          })
          .catch((err) => {
            store.dispatch("LogOut").then(() => {
              ElMessage.error(err);
              next({ path: "/" });
            });
          });
      } else {
        next();
      }
    }
  } else {
    // 没有token
    if (blackList.indexOf(to.path) !== -1) {
      // 在需要登录名单中，跳转login页面
      next(`/login?redirect=${to.fullPath}`); // 否则全部重定向到登录页
      NProgress.done();
    } else {
      next();
    }
  }
});

router.afterEach(() => {
  NProgress.done();
});
