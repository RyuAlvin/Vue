/**
 * 路由：
 *  1、理解：一个路由（route）就是一组映射关系（key-value），
 *          多个路由需要路由器（router）进行管理；
 *  2、前端路由：key是路径，value是组件；
 * 
 * 注意点：
 *  1、路由组件通常存放在pages文件夹，一般组件通常存放在components文件夹；
 *  2、通过切换，“隐藏”了的路由组件，默认是被销毁掉的，需要的时候再去挂载；
 *  3、每个组件都有自己的$route属性，里面存储着自己的路由信息；
 *  4、整个应用只有一个router，可以通过组件的$router属性获取到；
 */

/**
 * 安装vue-router：npm i vue-router
 *  vue@2 <-> vue-router@3
 *  vue@3 <-> vue-router@4
 */
import VueRouter from "vue-router";
import Home from "../pages/Home.vue";
import About from "../pages/About.vue";

export default new VueRouter({
  routes: [
    {
      path: "/About",
      component: About,
    },
    {
      path: "/Home",
      component: Home,
    },
  ],
});
