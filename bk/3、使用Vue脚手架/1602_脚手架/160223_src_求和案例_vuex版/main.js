import Vue from "vue";
import App from "./App.vue";
import VueResource from "vue-resource";
// 引入store
import store from "./store/index";
Vue.use(VueResource);

Vue.config.productionTip = false;
const vm = new Vue({
  el: "#app",
  store,
  render: (h) => h(App),
});

// console.log("Vue", vm);
