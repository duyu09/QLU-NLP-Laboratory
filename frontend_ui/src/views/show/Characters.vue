<template>
  <div class="">
    <div class="index_main">
      <div class="left_box">
        <h2>人物志</h2>
        <div v-for="(item, indexs) in characterList" :key="indexs">
          <h2>{{ item.title }}</h2>
          <div style="display: flex; flex-wrap: wrap">
            <div
              class="right_card"
              v-for="(character, index) in item.characters"
              :key="index"
            >
              <el-card style="margin: 0" :body-style="{ padding: '0px' }">
                <img
                  :src="showImgUrl + character.imgUrl"
                  class="image"
                  alt="人物志图片"
                />
                <div class="bottom clearfix" style="padding: 5px 14px">
                  <span class="title">{{ character.nameTitle }}</span>
                  <router-link
                    :to="{
                      name: 'CharacterPage',
                      query: {
                        configId: character.configId,
                        characterId: character.id,
                      },
                    }"
                  >
                    <el-button type="text" class="button">更多 》</el-button>
                  </router-link>
                </div>
              </el-card>
            </div>
          </div>
        </div>
      </div>
      <div class="right_box">
        <div v-for="(item, indexs) in announcementList" :key="indexs">
          <h2>{{ item.title }}</h2>
          <div
            class="announcement_card"
            v-for="(announcement, index) in item.announcements"
            :key="index"
          >
            <div>
              <div class="bottom clearfix" style="padding: 5px 14px">
                <span class="title">{{ announcement.title }}</span>
                <router-link
                  :to="{
                    name: 'Contribution',
                    query: {
                      configId: announcement.configId,
                      announcementId: announcement.id,
                    },
                  }"
                >
                  <el-button type="text" class="button">更多 》</el-button>
                </router-link>
              </div>
              <div class="ql-container">
                <div
                  class="ql-editor"
                  v-html="announcement.synopsisContent"
                ></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div
    v-loading.fullscreen.lock="loading"
    element-loading-text="加载中"
    element-loading-spinner="el-icon-loading"
    element-loading-background="rgba(0, 0, 0, 0.8)"
  ></div>
</template>

<script>
import { listCharacter } from "@/api/show/character";
import { listAnnouncement } from "@/api/show/announcement";

export default {
  name: "characters",
  dicts: ["qlu_character", "sys_normal_disable"],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 图片显示路径
      showImgUrl: process.env.VUE_APP_BASE_API,
      // 人物志数据
      characterList: [],
      // 公告通知数据
      announcementList: [],
    };
  },
  created() {
    // 获取人物志信息
    this.getCharacterList("qlu_character");
    // 获取通知公告信息
    this.getAnnouncementList("qlu_announcement");
  },
  methods: {
    /** 查询人物志列表 */
    getCharacterList(date) {
      this.loading = true;
      listCharacter(date).then((response) => {
        this.characterList = response.data;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询公告通知列表 */
    getAnnouncementList(date) {
      this.loading = true;
      listAnnouncement(date).then((response) => {
        this.announcementList = response.data;
        this.total = response.total;
        this.loading = false;
      });
    },
  },
  mounted() {},
};
</script>

<style scoped>
.index_main {
  width: 100%;
  margin: 0;
  display: flex;
}

.left_box {
  flex: 3;
  display: flex;
  flex-wrap: wrap;
}

.right_card {
  display: flex;
  flex-direction: row;
}

.right_box {
  flex: 1;
}

.announcement_card {
  width: 100%;
  padding: 2px;
  background-color: #f5f5f5;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.title {
  padding: 0;
  line-height: 1.5;
  font-size: 17px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both;
}
</style>
