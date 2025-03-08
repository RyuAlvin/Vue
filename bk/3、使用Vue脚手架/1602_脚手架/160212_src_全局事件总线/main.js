/**
 * 全局事件总线（GlobalEventBus）
 *  1、一种组件间通信的方式，适用于任意组件间通信；
 *  2、安装全局事件总线：
 *      new Vue({
 *        ...
 *        beforeCreate() {
 *          Vue.prototype.$bus = this //安装全局事件总线，$bus就是当前应用的vm
 *        },
 *        ...
 *      })
 *  3、使用事件总线：
 *    （1）、接收数据：A组件想接收数据，则在A组件中给$bus绑定自定义事件，事件的回调留在A组件自身；
            methods: {
              studentToSchool(value) {
                this.receiveVal = value;
              },
            },
            mounted() {
              this.$bus.$on("studentToSchool", this.studentToSchool);
            },
            beforeDestroy() {
              this.$bus.$off("studentToSchool");
            }
        (2)、提供数据：this.$bus.$emit('xxx', 数据)
    4、最好在 beforeDestroy 钩子中，用$off去解绑当前组件所用到的事件；
 */

import Vue from "vue";
import App from "./App.vue";

Vue.config.productionTip = false;
// const VC = Vue.extend({});
// const vc = new VC();
new Vue({
  el: "#app",
  render: (h) => h(App),
  beforeCreate() {
    Vue.prototype.$bus = this;
  },
});
