import Vue from "vue";
import App from "./App.vue";
/**
 * 完整引入
 */
// import ElementUI from 'element-ui';
// import 'element-ui/lib/theme-chalk/index.css';
// Vue.use(ElementUI)

/**
 * 按需引入，注册全局组件
 *  修改配置文件，重启项目
 */
import { Button, Row, DatePicker } from "element-ui";
Vue.component("ryu-button", Button);
Vue.component("ryu-row", Row);
Vue.component("ryu-datePicker", DatePicker);

Vue.config.productionTip = false;

new Vue({
  el: "#app",
  render: (h) => h(App),
});
