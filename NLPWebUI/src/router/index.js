import { createWebHistory, createRouter } from 'vue-router'
import HomePage from "../views/HomePage.vue";

// 公共路由
export const constantRoutes = [
  {
    name:'empty',
    path:'/empty',
    component:()=>import('../views/Empty.vue')
  },
  //首页
  {
    name:'home',
    path:'/',
    component:HomePage
  },
  //新闻列表
  {
    name:'newslist',
    path:'/newslist',
    component: ()=>import('../views/NewsList.vue')
  },
  //新闻详情
  {
    name:'newsdetail',
    path:'/newsdetail',
    component: ()=>import('../views/NewsDetail.vue')
  },
  //学术资源
  {
    name:'academic_resource',
    path:'/academicresource',
    component:()=>import('../views/AcademicResource.vue')
  },
  //人才培养
  {
    name:'studentcultivation',
    path:'/studentcultivation',
    component:()=>import('../views/StudentCultivation.vue')
  },
  //学生管理
  {
    name:'studentmanage',
    path:'/studentmanage',
    component:()=>import('../views/StudentManage.vue')
  },
  //团队掠影
  {
    name:'teamoverview',
    path:'/teamoverview',
    component:()=>import('../views/TeamOverview.vue')
  },
  //教师主页
  {
    name:"teacherPage",
    path:'/teacherPage',
    component:()=>import('../views/TeacherPage.vue')
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes: constantRoutes,

});


export default router;
