import Vue from 'vue'
import App from './App'

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App)
})

/**
 * AST：Abstract Syntax Tree，抽象语法树
 * VM：virtual DOM，虚拟DOM
 * 
 * render => VM => UI
 *  运行阶段（Render => VM => UI）：执行渲染函数，生成虚拟DOM，通过Diff和Patch更新真实DOM。
 * 
 *  runtime-only的代码更少，少了将模板编译成渲染函数这个阶段，直接通过渲染函数将组件生成虚拟DOM，更加高效。
 */