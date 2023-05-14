<template>
  <div>
    <v-md-editor
      v-model="content"
      :placeholder="placeholder"
      left-toolbar="undo redo clear | h alignCenter alignRight tab bold italic strikethrough quote | ul ol table hr | link image imageSize code | save"
      :toolbar="toolbar"
      :disabled-menus="[]"
      @upload-image="handleUploadImage"
      height="500px"></v-md-editor>
  </div>
</template>

<script>
import { getToken } from "@/utils/auth";

export default {
  name: 'MarkdownEditor',
  props: {
    // 占位符
    placeholder: {
      type: String,
      default: () => ''
    },
    // 当前组件值
    value: {
      type: Object,
      default: () => ''
    }
  },
  data() {
    return {
      // content: this.content,
      uploadUrl: process.env.VUE_APP_BASE_API + "/common/upload", // 上传的图片服务器地址
      headers: {
        Authorization: "Bearer " + getToken()
      },
      toolbar: {
        imageSize: {
          title: '初始化图片大小',
          icon: 'v-md-icon-img',
          action(editor) {
            editor.insert(function(selected) {
              const prefix = '{{{width="';
              const fix = '" height="';
              const suffix = '"}}}';
              const placeholder1 = '100';
              const placeholder2 = 'auto';
              const width = selected || placeholder1;
              const height = selected ||  placeholder2;

              return {
                text: `${prefix}${width}${fix}${height}${suffix}`,
                selected: width,
              };
            });
          }
        },
        tab: {
          title: '一键缩进',
          icon: 'el-icon-caret-right',
          action(editor) {
            editor.insert(function() {
              const tab = '&ensp;';
              return {
                text: `${tab}`,
              };
            });
          }
        },
        alignCenter: {
          title: '居中(h1-h3)',
          icon: 'el-icon-s-operation',
          menus: [
            {
              name: 'center1',
              text: '一级居中',
              action(editor) {
                editor.insert(function(selected) {
                  const head1 = '<h1 ';
                  const head2 = '</h1';
                  const foot = '>';
                  const align = 'align="center"';
                  const placeholder = '一级居中';
                  const content = selected || placeholder;

                  return {
                    text: `${head1}${align}${foot}${content}${head2}${foot}`,
                    selected: content,
                  };
                });
              },
            },
            {
              name: 'center2',
              text: '二级居中',
              action(editor) {
                editor.insert(function(selected) {
                  const head1 = '<h2 ';
                  const head2 = '</h2';
                  const foot = '>';
                  const align = 'align="center"';
                  const placeholder = '二级居中';
                  const content = selected || placeholder;

                  return {
                    text: `${head1}${align}${foot}${content}${head2}${foot}`,
                    selected: content,
                  };
                });
              },
            },
            {
              name: 'center3',
              text: '三级居中',
              action(editor) {
                editor.insert(function(selected) {
                  const head1 = '<h3 ';
                  const head2 = '</h3';
                  const foot = '>';
                  const align = 'align="center"';
                  const placeholder = '三级居中';
                  const content = selected || placeholder;

                  return {
                    text: `${head1}${align}${foot}${content}${head2}${foot}`,
                    selected: content,
                  };
                });
              },
            },
          ],
        },
        alignRight: {
          title: '居右(h2-h4)',
          icon: 'el-icon-s-unfold',
          menus: [
            {
              name: 'right2',
              text: '二级居右',
              action(editor) {
                editor.insert(function(selected) {
                  const head1 = '<h2 ';
                  const head2 = '</h2';
                  const foot = '>';
                  const align = 'align="right"';
                  const placeholder = '二级居右';
                  const content = selected || placeholder;

                  return {
                    text: `${head1}${align}${foot}${content}${head2}${foot}`,
                    selected: content,
                  };
                });
              },
            },
            {
              name: 'right3',
              text: '三级居右',
              action(editor) {
                editor.insert(function(selected) {
                  const head1 = '<h3 ';
                  const head2 = '</h3';
                  const foot = '>';
                  const align = 'align="right"';
                  const placeholder = '三级居右';
                  const content = selected || placeholder;

                  return {
                    text: `${head1}${align}${foot}${content}${head2}${foot}`,
                    selected: content,
                  };
                });
              },
            },
            {
              name: 'right4',
              text: '四级居右',
              action(editor) {
                editor.insert(function(selected) {
                  const head1 = '<h4 ';
                  const head2 = '</h4';
                  const foot = '>';
                  const align = 'align="right"';
                  const placeholder = '四级居右';
                  const content = selected || placeholder;

                  return {
                    text: `${head1}${align}${foot}${content}${head2}${foot}`,
                    selected: content,
                  };
                });
              },
            },
          ],
        },
      },
    };
  },
  computed: {
    // 通过计算属性进行双向绑定
    content: {
      get () {
        return this.value
      },
      set (newVal) {
        // emit 一个 input 事件出去则会修改掉 v-model 的值，vue 自动处理的，只管抛出去新的值即可。
        this.$emit('input', newVal)
      }
    }
  },
  methods: {
    handleUploadImage(event, insertImage, file) {
      // 拿到 files 之后上传到文件服务器，然后向编辑框中插入对应的内容
      const forms = new FormData()
      const configs = {
        headers: this.headers,
      }
      forms.append('file',file[0]);
      this.axios.post(this.uploadUrl, forms ,configs).then(res=>{
        if (res.data.code == 200) {
          insertImage({
            url: process.env.VUE_APP_BASE_API + res.data.fileName,
            // width: 'auto',
            // height: 'auto',
          });
        } else {
          this.$message.error("图片插入失败");
        }
      });
    },
  },
}
</script>

<style scoped lang="scss">
//.v-md-editor__toolbar-item v-md-icon-preview v-md-editor__toolbar-item-preview v-md-editor__toolbar-item--active {
//  display: none;
//}
.v-md-editor__toolbar-right {
  li.v-md-editor__toolbar-item v-md-icon-preview v-md-editor__toolbar-item-preview{
    display: none !important;
  }
}
</style>
