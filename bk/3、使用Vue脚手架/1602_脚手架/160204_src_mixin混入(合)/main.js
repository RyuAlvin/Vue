import Vue from "vue";
import App from "./App.vue";
import { m, n } from "./mixin_common";
Vue.config.productionTip = false;
//如果是全局混入，并且混入中配置了mounted，有多少个Vue组件节点，就会挂载几次
/**
 *  <Root>
 *      <App>
 *          <School></School>
 *          <Student></Student>
 *      </App>
 *  </Root>
 */
Vue.mixin(m);
Vue.mixin(n);
new Vue({
  el: "#app",
  render: (h) => h(App),
});
