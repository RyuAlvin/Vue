import Vue from 'vue'
import App from './App.vue'
import router from './router'
/**
 * 在入口main.js中引入store，并作为Vue的成员注册到Vue对象中
 * 在其他组件中就可以直接使用，使用方法：
 *  1、在模板中，通过$store.state可直接使用共享数据
 *  2、在方法中，通过this.$store.commit('mutations中定义的方法', 数据)
 */
import store from './store'

Vue.config.productionTip = false

// 创建事件总线并添加到 Vue 原型
Vue.prototype.$bus = new Vue();

/**
 * main.js使用插件
 * => 该插件是一个对象。必须包含实例、虚拟DOM、挂载对象，即：
 *  1、创建Vue实例
 *  2、使用渲染函数（createElement）告诉Vue要渲染的DOM元素
 *  3、将渲染结果挂载到页面上的指定元素
 * => 该插件制作：
 *  1、创建vue文件、index.js文件
 *  2、index.js需要返回一个Vue对象，所以该对象需要提供一个install方法
 *  3、install方法：
 *     a、通过Vue.extend创建自定义的Vue的子类，即构造函数
 *     b、构造函数中定义Vue的数据，方法、计算属性等内容（或直接传入导入的Vue模块）
 *     c、通过构造函数创建Vue组件实例
 *     d、将Vue组件实例手动挂载到指定元素上
 *     e、将该实例的$el添加到document.body上
 *     f、在Vue的原型上注册组件实例
 */
import SelfToast from './components/common/selfToast'
Vue.use(SelfToast);

/**
 * npm install fastclick@1.0.6 --save
 * FastClick是一个专门用于解决移动端浏览器点击事件延迟问题的JavaScript库
 * 问题背景：300ms点击延迟
 *    为什么存在延迟？
 *      - 早期移动浏览器为了区分单击和双击缩放操作
 *      - 浏览器需要等待约300ms来判断用户是单击还是双击
 *      - 这导致点击操作有明显的延迟感
 *    受影响的操作：
 *      element.addEventListener('click', function() { // 不会立即触发 });
 */
import FastClick from 'fastclick'
FastClick.attach(document.body);

// npm install vue-lazyload@1.2.6 --save
import VueLazyload from 'vue-lazyload'
// 基本配置
// Vue.use(VueLazyload);
// 或使用自定义配置
Vue.use(VueLazyload, {
  loading: require('assets/img/common/placeholder.svg')
})

new Vue({
  render: h => h(App),
  store,
  router
}).$mount('#app')

/**
 * 编译打包 npm run build => dist文件夹
 * cmd 命令进入nginx根文件夹
 *  启动：start ngi 
 *  停止：nginx -s stop
 * nginx.config 默认访问路径为html文件夹下的资源
 *  可更改访问路径文件夹，或者直接将html下的资源替换
 */