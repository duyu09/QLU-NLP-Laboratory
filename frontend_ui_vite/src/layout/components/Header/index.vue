<template>
  <div class="site-header site-header__header-one" >
    <div class="sidebar-pc-container">
      <div class="navbar navbar-expand-lg navbar-light header-navigation stricky" :class="{ 'has-logo': showLogo }" :style="{ backgroundColor: sideTheme === 'theme-dark' ? variables.menuBackground : variables.menuLightBackground }">
        <div class="container clearfix" style="padding: 0 10px" >
          <el-row :gutter="20">
            <el-col :span="3">
              <!-- Brand and toggle get grouped for better mobile display -->
              <logo :collapse="isCollapse" />
            </el-col>
            <el-col :span="14">
              <!-- Collect the nav links, forms, and other content for toggling -->
              <el-scrollbar :class="sideTheme" wrap-class="scrollbar-wrapper">
                <el-menu
                    :default-active="activeMenu"
                    :background-color="sideTheme === 'theme-dark' ? variables.menuBackground : variables.menuLightBackground"
                    :text-color="sideTheme === 'theme-dark' ? variables.menuColor : variables.menuLightColor"
                    :unique-opened="true"
                    :active-text-color="theme"
                    :collapse-transition="false"
                    mode="horizontal"
                >
                  <sidebar-item
                      v-for="(route, index) in sidebarRouters"
                      :key="route.path + index"
                      :item="route"
                      :base-path="route.path"
                  />
                </el-menu>
              </el-scrollbar>
            </el-col>
            <el-col :span="4"  v-if="appStore.device !== 'mobile'">
              <header-search id="header-search" class="right-menu-item" />
            </el-col>
            <el-col :span="3">
              <user-login :show-menu="true"/>
            </el-col>
          </el-row>
        </div>
        <!-- /.container -->
      </div>
    </div>
    <div class="sidebar-mobile-container">
      <div class="navbar navbar-expand-lg navbar-light header-navigation stricky" :class="{ 'has-logo': showLogo }" :style="{ backgroundColor: sideTheme === 'theme-dark' ? variables.menuBackground : variables.menuLightBackground }">
        <div class="container clearfix" style="padding: 0 10px" >
          <el-row :gutter="20" style="z-index: 3000;">
            <el-col :span="5">
              <div style="margin: 11px;" v-if="!openMenu" @click="openMenu = true">
                <el-icon><Promotion /></el-icon>
              </div>
              <div style="margin: 11px;" v-if="openMenu" @click="openMenu = false">
                <el-icon><Close /></el-icon>
              </div>
            </el-col>
            <el-col :span="13">
              <!-- Brand and toggle get grouped for better mobile display -->
              <logo :collapse="isCollapse" />
            </el-col>
            <el-col :span="6">
              <user-login :show-menu="!openMenu" />
            </el-col>
          </el-row>
          <el-row>
            <el-drawer v-model="openMenu" direction="ttb" size="50%" :show-close="false">
              <!-- Collect the nav links, forms, and other content for toggling -->
              <el-scrollbar :class="sideTheme" wrap-class="scrollbar-wrapper">
                <el-menu
                    :default-active="activeMenu"
                    :background-color="sideTheme === 'theme-dark' ? variables.menuBackground : variables.menuLightBackground"
                    :text-color="sideTheme === 'theme-dark' ? variables.menuColor : variables.menuLightColor"
                    :unique-opened="true"
                    :active-text-color="theme"
                    :collapse-transition="false"
                    mode="vertical"
                >
                  <sidebar-item
                      v-for="(route, index) in sidebarRouters"
                      :key="route.path + index"
                      :item="route"
                      :base-path="route.path"
                  />
                </el-menu>
              </el-scrollbar>
            </el-drawer>
          </el-row>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import Logo from './Logo'
import SidebarItem from './SidebarItem'
import UserLogin from './UserLogin'
import variables from '@/assets/styles/variables.module.scss'
import useAppStore from '@/store/modules/app'
import useSettingsStore from '@/store/modules/settings'
import usePermissionStore from '@/store/modules/permission'
import HeaderSearch from '@/components/HeaderSearch'

const route = useRoute();
const appStore = useAppStore()
const settingsStore = useSettingsStore()
const permissionStore = usePermissionStore()

const sidebar = computed(() => useAppStore().sidebar);
const device = computed(() => useAppStore().device);
const sidebarRouters =  computed(() => permissionStore.sidebarRouters);
const sideTheme = computed(() => settingsStore.sideTheme);
const theme = computed(() => settingsStore.theme);
const isCollapse = computed(() => !appStore.sidebar.opened);

const activeMenu = computed(() => {
  const { meta, path } = route;
  // if set path, the sidebar will highlight the path you set
  if (meta.activeMenu) {
    return meta.activeMenu;
  }
  return path;
})

const openMenu = ref(false)

</script>

<style lang='scss' scoped>

.sidebar-mobile-container {

  i {
    font-size: 35px;
  }

}

</style>
