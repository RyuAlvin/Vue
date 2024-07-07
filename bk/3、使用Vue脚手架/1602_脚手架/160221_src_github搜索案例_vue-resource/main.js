import App from "./App.vue";
import Vue from "vue";
// vue-resource为默认暴露，所以名字自由命名
// vue-resource官方已不怎么维护了
import xxx from "vue-resource";

Vue.config.productionTip = false;
// 使用插件
Vue.use(xxx);
new Vue({
  el: "#app",
  render: (h) => h(App),
  beforeCreate() {
    Vue.prototype.$bus = this;
  },
});
