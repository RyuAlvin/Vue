import VueRouter from "vue-router";
import Home from "../pages/Home.vue";
import About from "../pages/About.vue";
import Message from "../pages/Message.vue";
import News from "../pages/News.vue";
import Detail from "../pages/Detail.vue";

const router = new VueRouter({
  /**
   * 路由器的两种工作模式：
   *  1、对于一个url来说，什么事hash值？
   *    http://localhost:8080/#/Home/Message
   *    ->#及其后面的内容就是hash值；
   *  2、hash值不会包含在HTTP请求中，即：hash值不会带给服务器；
   *    url显示的实际是前端路由，当刷新页面时，不会报404错误（服务器找不到资源）
   *  3、hash模式：
   *    a、地址中永远带着#号，不美观；
   *    b、若以后将地址通过第三方手机app分享，若app校验严格，则地址会被标记为不合法；
   *        实际上时app认为你这个地址分享后是无效的；
   *    c、兼容性较好（浏览器）；
   *  4、history模式：
   *    a、地址干净、美观；
   *    b、兼容性和hash模式相比略差；
   *    c、应用部署上线时需要后端人员支持（区分前端路由和后端路由），解决刷新页面服务端404的问题；
   *  5、拓展：解决前后端路由区分还可以用nginx
   */
  mode: "history",
  // 默认
  // mode: "hash",
  routes: [
    {
      name: "guanyu",
      path: "/About",
      component: About,
      meta: { title: "About" },
    },
    {
      path: "/Home",
      component: Home,
      meta: { title: "Home" },
      children: [
        {
          //此处一定不要写/News，不要带斜杠
          path: "News",
          component: News,
          meta: { title: "News", isAuth: true },
        },
        {
          path: "Message",
          component: Message,
          // beforeEnter: (to, from, next) => {
          //   if (to.meta.isAuth) {
          //     if (localStorage.getItem("name") === "ryu") {
          //       next();
          //     } else {
          //       alert("用户名不对！");
          //     }
          //   } else {
          //     next();
          //   }
          // },
          meta: { title: "Message", isAuth: true },
          children: [
            {
              name: "xiangxi",
              path: "Detail",
              component: Detail,
              meta: { title: "Detail", isAuth: true },
              props({ query: { id, title } }) {
                return {
                  id: id,
                  title: title,
                };
              },
            },
          ],
        },
      ],
    },
  ],
});

// /**
//  * 全局前置路由守卫：
//  *  初始化的时候被调用、每次路由切换之前被调用
//  */
// router.beforeEach((to, from, next) => {
//   if (to.meta.isAuth) {
//     if (localStorage.getItem("name") === "ryu") {
//       next();
//     } else {
//       alert("用户名不对！");
//     }
//   } else {
//     next();
//   }
// });

/**
 * 全局后置路由守卫：
 *  初始化的时候被调用、每次路由切换之后被调用
 */
router.afterEach((to, from) => {
  document.title = to.meta.title || "Hello World";
});

export default router;
