import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import { resetForm } from "@/utils/train";

import ElementPlus from "element-plus";
import "element-plus/dist/index.css";
import ECharts from 'vue-echarts'
import { use } from "echarts/core";

import "./permission";

// 图片上传组件
import ImageUpload from "@/components/ImageUpload";
// 分页组件
import Pagination from "@/components/Pagination";

import axios from "axios";
import VueAxios from "vue-axios";


// 手动引入 ECharts 各模块来减小打包体积
import {
  CanvasRenderer
} from 'echarts/renderers'
import {
  BarChart
} from 'echarts/charts'
import {
  GridComponent,
  TooltipComponent
} from 'echarts/components'

use([
  CanvasRenderer,
  BarChart,
  GridComponent,
  TooltipComponent
]);

const app = createApp(App);

app.use(store);
app.use(router);
app.use(ElementPlus);
app.use(VueAxios, axios);

// ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ 全局引入markdown文本编辑框 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
import "github-markdown-css/github-markdown.css";
import VueQuillEditor from "vue-quill-editor";

// require styles
import "quill/dist/quill.core.css";
import "quill/dist/quill.snow.css";
import "quill/dist/quill.bubble.css";
// 引入预览组件
import VMdPreview from "@kangc/v-md-editor/lib/preview";
import "@kangc/v-md-editor/lib/style/preview.css";
import githubTheme from "@kangc/v-md-editor/lib/theme/github.js";
import "@kangc/v-md-editor/lib/theme/style/github.css";

// 引入预览组件
// highlightjs
import hljs from "highlight.js";

VMdPreview.use(githubTheme, {
  Hljs: hljs,
});

app.use(VueQuillEditor).use(VMdPreview);
// ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ 全局引入markdown文本编辑框 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

// 全局方法挂载
app.config.globalProperties.resetForm = resetForm;

// // 全局组件挂载
app.component("ImageUpload", ImageUpload);
app.component("Pagination", Pagination);

// 全局注册组件（也可以使用局部注册）
app.component('v-chart', ECharts)

app.mount("#app");
