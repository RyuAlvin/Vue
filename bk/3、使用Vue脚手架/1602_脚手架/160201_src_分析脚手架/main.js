/**
 * 该文件是整个项目的入口文件
 */
//引入Vue
/**
 * dist/vue.runtime.esm.js 残缺版的包（esm->ES6 module），不能解析template（没有模版解析器的功能），必须搭配render使用。
 * 原因：Vue=Vue核心+模版解析器
 *  如果用vue.js，在你项目完成时需要编译打包，模版解析器会将项目编译成浏览器能够读懂的文件（.css,.html,.js），
 *  但当编译打包结束，你的整个包文件中还保留了模版解析器，就显得多余了。
 *  至于vue文件中的<template></template>，即使你用了xxx.esm.js，虽然这里面不带有模版解析器的功能，
 *    但是在package.json中已经专门配置了 "vue-template-compiler": "^2.6.14"
 */
import Vue from 'vue'
//引入App组件，它是所有组件的父组件
// import App from './App.vue'
//关闭Vue的生产提示
Vue.config.productionTip = false

//创建Vue实例对象 vm
new Vue({
  //将App组件放入容器中
  // render: h => h(App),
  //完整写法：
  render(createElement){
    return createElement('h1','HELLO WORLD')
  },
  el:'#app'
})
// }).$mount('#app')

/**
 * 关于不同版本的Vue：
 *  1、vue.js与vue.runtime.xxx.js的区别：
 *    （1）、vue.js是完整版的Vue，包含：核心功能+模版解析器；
 *    （2）、vue.runtime.xxx.js是运行版的Vue，只包含：核心功能；没有模版解析器；
 *  2、因为vue.runtime.xxx.js没有模版解析器，所以不能使用template配置项，
 *      需要使用render函数接受到的createElement函数去指定具体内容；
 */