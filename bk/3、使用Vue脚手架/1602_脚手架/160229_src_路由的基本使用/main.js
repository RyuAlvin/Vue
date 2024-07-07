import Vue from "vue";
import App from "./App.vue";
import router from "./router";
// 引入vue-router
import VueRouter from "vue-router";

Vue.config.productionTip = false;
// 应用vue-router插件
Vue.use(VueRouter)
new Vue({
  el: "#app",
  render: (h) => h(App),
  router: router,
});