import Vue from "vue";
import App from "./App.vue";
import store from "./store/index";

Vue.config.productionTip = false;
const vm = new Vue({
  el: "#app",
  render: (h) => h(App),
  store,
});