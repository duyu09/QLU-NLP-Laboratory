<template>
  <div class="header-login">
    <div v-if="!getToken()" class="header-login-btn">
      <el-button
          size="large"
          type="primary"
          style="width:100%;"
      >
        <router-link to="/login">
          <span>登 录 / 注 册</span>
        </router-link>
      </el-button>
    </div>
    <div v-if="getToken()" class="avatar-container">
      <el-dropdown @command="handleCommand" class="right-menu-item hover-effect" trigger="click">
        <div class="avatar-wrapper">
          <img :src="userStore.avatar" class="user-avatar" />
          <el-icon v-if="props.showMenu"><caret-bottom /></el-icon>
        </div>
        <template #dropdown v-if="props.showMenu">
          <el-dropdown-menu>
            <router-link to="/user/profile">
              <el-dropdown-item>个人中心</el-dropdown-item>
            </router-link>
<!--            <el-dropdown-item command="setLayout">-->
<!--              <span>布局设置</span>-->
<!--            </el-dropdown-item>-->
            <el-dropdown-item divided command="logout">
              <span>退出登录</span>
            </el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div><!-- /.right-side-box -->
</template>

<script setup>
import { ElMessageBox } from 'element-plus'
import { getToken } from '@/utils/auth'
import useUserStore from "@/store/modules/user";
import useSettingsStore from '@/store/modules/settings'

const userStore = useUserStore()
const settingsStore = useSettingsStore()

const props = defineProps({
  // route object
  showMenu: {
    type: Object,
    required: true
  },
})

function handleCommand(command) {
  switch (command) {
    // case "setLayout":
    //   setLayout();
    //   break;
    case "logout":
      logout();
      break;
    default:
      break;
  }
}

function logout() {
  ElMessageBox.confirm('确定注销并退出系统吗？', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(() => {
    userStore.logOut().then(() => {
      location.href = '/index';
    })
  }).catch(() => { });
}

const emits = defineEmits(['setLayout'])
function setLayout() {
  emits('setLayout');
}

</script>

<style lang='scss' scoped>
.header-login {
  font-size: 0 !important;
  position: relative;
  width: 100%;
  height: 60px;
  line-height: 60px;
  text-align: center;
  overflow: hidden;


  .header-login-btn {
    font-size: 18px;
    transition: width 0.2s;
    width: 100%;
    overflow: hidden;
    background: transparent;
    border-radius: 0;
    display: inline-block;
    vertical-align: middle;
  }

  .avatar-container {
    margin-right: 40px;

    .avatar-wrapper {
      margin-top: 8px;
      position: relative;

      .user-avatar {
        cursor: pointer;
        width: 40px;
        height: 40px;
        border-radius: 10px;
      }

      i {
        cursor: pointer;
        position: absolute;
        right: -20px;
        top: 25px;
        font-size: 12px;
      }
    }
  }
}

</style>
