import { createRouter, createWebHistory } from "vue-router";

// 公共路由
const routes = [
  {
    path: "/",
    redirect: "/collection", // 重定向至首页
  },
  {
    // 人物志
    path: "/characters",
    name: "Characters",
    component: () => import("@/views/show/Characters"),
  },
  {
    // 人物志详情
    path: "/characterPage",
    name: "CharacterPage",
    component: () => import("@/views/show/CharacterPage"),
  },
  {
    // 贡献  成果 详情界面
    path: "/contribution",
    name: "Contribution",
    component: () => import("@/views/show/Contribution"),
  },
  {
    // 赛事列表
    path: "/contests",
    name: "Contests",
    component: () => import("@/views/show/Contests"),
  },
  {
    // 视频课程课程
    path: "/course",
    name: "Courses",
    component: () => import("@/views/show/Courses"),
  },
  {
    // 训练题集
    path: "/collection",
    name: "Collection",
    component: () => import("@/views/show/Collection"),
  },
  {
    // ICPC私云
    path: "/cloud",
    name: "Cloud",
    component: () => import("@/views/show/Cloud"),
  },
  {
    // domjudge
    path: "/domjudge",
    name: "Domjudge",
    component: () => import("@/views/show/Domjudge"),
  },
  {
    path: "/404",
    component: () => import("@/views/error/404"),
    hidden: true,
  },
  {
    path: "/401",
    component: () => import("@/views/error/401"),
    hidden: true,
  },
  {
    path: "/:pathMatch(.*)",
    redirect: "/404",
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
