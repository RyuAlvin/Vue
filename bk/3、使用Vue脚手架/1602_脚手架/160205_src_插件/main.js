import App from "./App.vue";
import Vue from "vue";
import plugins from "./plugins";

Vue.config.productionTip = false;

/**
 * 功能：用于增强Vue
 * 本质：包含install方法的一个对象，
 *          install的第一个参数是Vue，
 *          install的第二个以后的参数事插件使用者传递的数据；
 * 定义插件：
 *  对象.install = funciton (Vue, options) {
 *      // 1、添加全局过滤器
 *      Vue.filter( ... )
 * 
 *      // 2、添加全局指令
 *      Vue.directive( ... )
 * 
 *      // 3、配置全局混入(合)
 *      Vue.mixin( ... )
 * 
 *      // 4、添加实例方法
 *      Vue.prototype.$myMethod = function () { ... }
 *      Vue.prototype.$myProperty = xxx 
 * }
 * 
 * 使用插件：Vue.use(xxx)
 */
//使用插件，还可以穿入参数
Vue.use(plugins, 1111, "啦啦啦", "ooooo");
new Vue({
  el: "#app",
  render: (h) => h(App),
});
