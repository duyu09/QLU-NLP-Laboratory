import { createApp } from 'vue';
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';
//import { marked } from "marked";

import VMdPreview from '@kangc/v-md-editor/lib/preview';
import '@kangc/v-md-editor/lib/style/preview.css';
// 引入你所使用的主题 此处以 github 主题为例
import githubTheme from '@kangc/v-md-editor/lib/theme/github';
import '@kangc/v-md-editor/lib/theme/style/github.css';

// highlightjs
import hljs from 'highlight.js';

VMdPreview.use(githubTheme, {
    Hljs: hljs,
});

import VueAxios from 'vue-axios';

import App from './App.vue';
import axios from "axios";
import router from "../src/router/index";
const app = createApp(App);

app.use(VMdPreview);
app.use(VueAxios, axios);
app.use(router);
app.use(ElementPlus);
//app.use(marked);
app.mount('#app');
