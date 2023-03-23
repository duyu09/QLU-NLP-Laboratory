# 平台简介

属于快速开发demo平台的前台、中台服务项目，功能会陆续完善。

* 采用Vue3、Element-Plus。
* 默认引入markdown编辑器组件，功能可以继续
## 内置功能

1. 初始化页面：展示游客可查看内容
2. 用户登录：可登录后进入中台，进行部分操作
3. 组件化抽离：高度的封装组件，实现了组件的可复用性和代码的可读性

## 组件使用记录
```vue
markdown预览组件的使用
    <v-md-preview :text="item.recordContent"></v-md-preview>
```