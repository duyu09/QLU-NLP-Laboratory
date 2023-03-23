<template>
  <!--  课程-->
  <div>
    <h2>视频课程</h2>
    <el-container>
      <el-aside>
        <el-tabs tab-position="top" v-model="nowTab" @tab-click="handleClick">
          <el-tab-pane
            v-for="(item, indexs) in courseList"
            :name="indexs"
            :label="item.title"
            :key="indexs"
          >
            <el-menu :default-active="nowMenu" class="course_menu_box">
              <el-menu-item
                v-for="(course, index) in item.courses"
                :index="index"
                @click="change(index)"
                :key="index"
              >
                {{ course.name }}
              </el-menu-item>
            </el-menu>
          </el-tab-pane>
        </el-tabs>
      </el-aside>
      <el-container class="outter-container">
        <el-container
          class="frame-container"
          v-if="nowCourseShow.videoLink !== ''"
        >
          <div>
            <h2 style="margin: 0">{{ nowCourseShow.title }}</h2>
            <el-button
              type="text"
              class="button"
              style="display: flex; float: right"
              @click="dialogVisible = true"
            >
              介绍 》
            </el-button>
          </div>
          <iframe
            class="frame"
            :src="nowCourseShow.videoLink + '&high_quality=1'"
            scrolling="no"
            border="0"
            frameborder="no"
            framespacing="0"
            allowfullscreen="true"
          >
          </iframe>
          <div class="windows-box">
            <el-button-group
              style="display: flex; padding: 20px 0 0; float: right"
            >
              <el-button
                class="down-button"
                v-if="nowCourseShow.downPdfLink !== null"
                @click="downVideo"
              >
                下载本节课视频
              </el-button>
              <el-button
                type="primary"
                class="down-button"
                v-if="nowCourseShow.downVideoLink !== null"
                @click="downPdf"
              >
                下载本节课配套文档
              </el-button>
            </el-button-group>
          </div>
        </el-container>
        <el-container class="frame-container" v-else>
          <h2>视频还未上线</h2>
          <div>
            <v-md-preview :text="nowCourseShow.recordContent"></v-md-preview>
          </div>
        </el-container>
      </el-container>
    </el-container>
    <!--    弹出框-->
    <el-dialog width="60%" :title="nowCourseShow.title" v-model="dialogVisible">
      <div>
        <v-md-preview :text="nowCourseShow.recordContent"></v-md-preview>
      </div>
    </el-dialog>
    <!--    加载框-->
    <div
      v-loading.fullscreen.lock="loading"
      element-loading-text="加载中"
      element-loading-spinner="el-icon-loading"
      element-loading-background="rgba(0, 0, 0, 0.8)"
    ></div>
  </div>
</template>

<script>
import { listCourse } from "@/api/show/course";

export default {
  name: "Courses",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 视频数据
      courseList: [],
      nowTab: 0,
      nowMenu: 0,
      // 现在展示的视频数据
      nowCourseShow: {},
      // 下载首路径
      updateTitleUrl: process.env.VUE_APP_BASE_API,
      // 弹出框是否展示
      dialogVisible: false,
    };
  },
  mounted() {},
  created() {
    if (
      this.$route.query.nowTab === undefined ||
      this.$route.query.nowMenu === undefined
    ) {
      this.nowTab = 0;
      this.nowMenu = 0;
      this.$router.push({
        query: {
          ...this.$route.query,
          nowTab: this.nowTab,
          nowMenu: this.nowMenu,
        },
      });
    } else {
      console.log(this.$route.query.nowTab);
      this.nowTab = parseInt(this.$route.query.nowTab, 10);
      this.nowMenu = parseInt(this.$route.query.nowMenu, 10);
    }
    // 获取视频数据
    this.getCourseList("qlu_course");
  },
  methods: {
    /** 查询视频数据 */
    getCourseList(date) {
      this.loading = true;
      listCourse(date).then((response) => {
        this.courseList = response.data;
        this.nowCourseShow = this.courseList[this.nowTab].courses[this.nowMenu];
        this.total = response.total;
        this.loading = false;
      });
    },
    // 变换视频类型
    handleClick() {
      this.nowMenu = 0;
      this.$router.push({
        query: {
          ...this.$route.query,
          nowTab: this.nowTab,
          nowMenu: this.nowMenu,
        },
      });
      this.nowCourseShow = this.courseList[this.nowTab].courses[this.nowMenu];
    },
    // 点击视频menu
    change: function (index) {
      this.nowMenu = index;
      this.$router.push({
        query: {
          ...this.$route.query,
          nowTab: this.nowTab,
          nowMenu: this.nowMenu,
        },
      });
      this.nowCourseShow = this.courseList[this.nowTab].courses[this.nowMenu];
    },
    downPdf: function () {
      window.location = this.updateTitleUrl + this.nowCourseShow.downPdfLink;
    },
    downVideo: function () {
      window.location = this.updateTitleUrl + this.nowCourseShow.downVideoLink;
    },
  },
};
</script>

<style scoped>
.el-container {
  color: rgb(34, 34, 34);
  display: flex;
}

.el-menu-item {
  overflow-x: auto;
  overflow-y: hidden;
  display: flex;
  flex-direction: row;
  column-count: 1;
}

.el-menu-item::-webkit-scrollbar {
  display: none;
}

.el-aside {
  flex: 1;
  transition: 500ms;
}

/* .el-aside:hover {
  flex: 2;
} */
/* 导航menu */
.course_menu_box {
  overflow-y: auto;
  height: 600px;
}

.outter-container {
  flex: 4 !important;
  text-align: center;
}

.frame-container {
  padding: 20px;
  flex-direction: column !important;
  background: rgb(242, 242, 245);
}

.frame-container h2 {
  margin-block-start: 0.5em;
  margin-block-end: 0.8em;
  color: rgb(21, 41, 112);
  font-weight: 600;
}

.frame {
  height: 500px;
  width: 100%;
  max-width: 800px;
  transition: 200ms;
}

.down {
  right: 0;
  padding-top: 20px;
  bottom: 20px;
}

.down-button {
  width: 160px;
}

@media (max-height: 560px) {
  .vertial-hide {
    display: none;
  }
  .el-container {
    min-width: 100%;
  }
}

@media (min-width: 1150px) {
  .frame {
    height: 600px;
    max-width: 900px;
  }
}

@media (max-width: 1149px) {
  .frame {
    height: 450px;
    max-width: 700px;
  }
}

@media (max-width: 640px) {
  .el-container {
    flex-direction: column-reverse !important;
  }

  .el-header {
    text-align: center;
    line-height: 40px;
    height: 40px !important;
    font-size: 1rem;
  }

  .outter-container {
    padding: 0;
  }

  /* 导航menu */
  .course_menu_box {
    overflow-y: auto;
    height: 300px;
  }

  .frame-container {
    padding: 0;
  }

  .frame-container h4 {
    margin-left: 10px;
  }

  .frame {
    height: 200px;
  }

  .el-aside {
    width: 100% !important;
  }
}
</style>
