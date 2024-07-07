import VueRouter from "vue-router";
import Home from "../pages/Home.vue";
import About from "../pages/About.vue";
import Message from "../pages/Message.vue";
import News from "../pages/News.vue";
import Detail from "../pages/Detail.vue";

const router = new VueRouter({
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
          beforeEnter: (to, from, next) => {
            if (to.meta.isAuth) {
              if (localStorage.getItem("name") === "ryu") {
                next();
              } else {
                alert("用户名不对！");
              }
            } else {
              next();
            }
          },
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
