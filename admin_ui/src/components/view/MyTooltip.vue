<template>
  <el-tooltip class="item"
              effect="dark"
              placement="bottom-start"
              :visible-arrow="false">
    <div style="max-width:350px" slot="content" v-html="command"></div>
    <span :class="rows>3?'ellipsis_more':'ellipsis'" :style="rows>3?'-webkit-line-clamp:'+rows+';':''" v-html="command">
    </span>
  </el-tooltip>
</template>

<script>
export default {
  name: 'MyTooltip',
  props: {
    // width: {
    //   type: String,
    //   default: '100%'
    // },
    command: {
      type: String,
      default: '数据为空,请联系管理员'
    },
    rows:{
      type: String,
      default: "1"
    }
  },
  data() {return {};},
  methods: {
  },
}
</script>

<style scoped>
.ellipsis{
  white-space:nowrap;
  overflow:hidden;
  text-overflow:ellipsis;
}
.ellipsis_more{
  overflow:hidden;
  display:-webkit-box;
  -webkit-box-orient:vertical;
}
</style>
