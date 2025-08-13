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

new Vue({
  render: h => h(App),
  store,
  router
}).$mount('#app')
