<template>
  <div class="header-search show">
    <el-select
      ref="headerSearchSelectRef"
      v-model="search"
      :remote-method="querySearch"
      filterable
      default-first-option
      remote
      placeholder="Search"
      class="header-search-select"
      @change="change"
    >
      <el-option v-for="option in options" :key="option.item.path" :value="option.item" :label="option.item.title.join(' > ')" />
    </el-select>
  </div>
</template>

<script setup>
import Fuse from 'fuse.js'
import { getNormalPath } from '@/utils/ruoyi'
import { isHttp } from '@/utils/validate'
import usePermissionStore from '@/store/modules/permission'

const search = ref('');
const options = ref([]);
const searchPool = ref([]);
const fuse = ref(undefined);
const headerSearchSelectRef = ref(null);
const router = useRouter();
const routes = computed(() => usePermissionStore().routes);

function change(val) {
  const path = val.path;
  if (isHttp(path)) {
    // http(s):// 路径新窗口打开
    const pindex = path.indexOf("http");
    window.open(path.substr(pindex, path.length), "_blank");
  } else {
    router.push(path)
  }

  search.value = ''
  options.value = []
}
function initFuse(list) {
  fuse.value = new Fuse(list, {
    shouldSort: true,
    threshold: 0.4,
    location: 0,
    distance: 100,
    maxPatternLength: 32,
    minMatchCharLength: 1,
    keys: [{
      name: 'title',
      weight: 0.7
    }, {
      name: 'path',
      weight: 0.3
    }]
  })
}
// Filter out the routes that can be displayed in the sidebar
// And generate the internationalized title
function generateRoutes(routes, basePath = '', prefixTitle = []) {
  let res = []

  for (const r of routes) {
    // skip hidden router
    if (r.hidden) { continue }
    const p = r.path.length > 0 && r.path[0] === '/' ? r.path : '/' + r.path;
    const data = {
      path: !isHttp(r.path) ? getNormalPath(basePath + p) : r.path,
      title: [...prefixTitle]
    }

    if (r.meta && r.meta.title) {
      data.title = [...data.title, r.meta.title]

      if (r.redirect !== 'noRedirect') {
        // only push the routes with title
        // special case: need to exclude parent router without redirect
        res.push(data)
      }
    }

    // recursive child routes
    if (r.children) {
      const tempRoutes = generateRoutes(r.children, data.path, data.title)
      if (tempRoutes.length >= 1) {
        res = [...res, ...tempRoutes]
      }
    }
  }
  return res
}
function querySearch(query) {
  if (query !== '') {
    options.value = fuse.value.search(query)
  } else {
    options.value = []
  }
}

onMounted(() => {
  searchPool.value = generateRoutes(routes.value);
})

watchEffect(() => {
  searchPool.value = generateRoutes(routes.value)
})

watch(searchPool, (list) => {
  initFuse(list)
})
</script>

<style lang='scss' scoped>
.header-search {
  font-size: 0 !important;
  position: relative;
  width: 100%;
  height: 60px;
  line-height: 60px;
  text-align: center;
  overflow: hidden;


  .header-search-select {
    font-size: 18px;
    transition: width 0.2s;
    width: 100%;
    overflow: hidden;
    background: transparent;
    border-radius: 0;
    display: inline-block;
    vertical-align: middle;
  }

  &.show {
    .header-search-select {
      width: 150px;
      margin-left: 10px;
    }
  }
}
</style>
