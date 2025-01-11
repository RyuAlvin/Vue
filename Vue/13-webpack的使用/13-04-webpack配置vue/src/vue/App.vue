<!-- 
App.js中html和js代码混杂在一起，可读性差，用vue文件代替
但是此时用webpack打包的时候报错：
  You may need an appropriate loader to handle this file type.
解决：
  1、npm install --save-dev vue-loader@15.4.2 vue-template-compiler@2.5.21
  2、webpack.config.js配置 { test: /\.vue$/, use: ['vue-loader'] }
-->
<template>
  <div>
    <h1 class="App">我是App</h1>
    <p>{{ message }}</p>
    <button @click="btnClick">按钮1</button>
    <hr />
    <Cpn></Cpn>
  </div>
</template>

<script>
import Cpn from "./Cpn";

export default {
  data() {
    return {
      message: "我是App的内容",
    };
  },
  methods: {
    btnClick() {
      console.log("Hello App");
    },
  },
  components: {
    Cpn,
  },
};
</script>

<style>
.App {
  background-color: yellow;
}
</style>