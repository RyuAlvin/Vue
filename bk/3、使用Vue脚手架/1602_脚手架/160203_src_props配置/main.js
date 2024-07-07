import App from "./App.vue";
import Vue from "vue";
Vue.config.procutionTip = false;
new Vue({
  el: "#app",
  render: (h) => h(App),
});
