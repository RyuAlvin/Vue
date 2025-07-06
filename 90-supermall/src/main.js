import Vue from 'vue'
import App from './App.vue'
import router from './router'

Vue.config.productionTip = false

// 创建事件总线并添加到 Vue 原型
Vue.prototype.$bus = new Vue();

new Vue({
  render: h => h(App),
  router
}).$mount('#app')
