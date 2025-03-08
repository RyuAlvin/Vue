import VueRouter from "vue-router";
import Home from "../pages/Home.vue";
import About from "../pages/About.vue";
import Message from "../pages/Message.vue";
import News from "../pages/News.vue";
import Detail from "../pages/Detail.vue";

export default new VueRouter({
  routes: [
    {
      name: "guanyu",
      path: "/About",
      component: About,
    },
    {
      path: "/Home",
      component: Home,
      children: [
        {
          //此处一定不要写/News，不要带斜杠
          path: "News",
          component: News,
        },
        {
          path: "Message",
          component: Message,
          children: [
            {
              name: "xiangxi",
              path: "Detail/:id/:title",
              component: Detail,
              // 路由的props配置：让路由组件更方便地收到参数

              // 第一种写法：props值为对象，该对象中所有的key-value的组合最终都会通过props传给Detail组件
              // props: { a: "Hello", b: "World" },

              // 第二种写法：props值为布尔值，布尔值为true，则把路由收到的所有params参数通过props传给Detail组件
              //    注意：这种方式只能收到params
              // props: true,

              // 第三种写法：props值为函数，该函数返回的对象中每一组key-value都会通过props传给Detail组件
              //    结构赋值语法一：
              // props($route) {
              //   return {
              //     id: $route.query.id,
              //     title: $route.query.title,
              //     a: $route.query.a,
              //     b: $route.query.b,
              //   };
              // },
              //    结构赋值语法二：
              // props({ query }) {
              //   return {
              //     id: query.id,
              //     title: query.title,
              //     a: query.a,
              //     b: query.b,
              //   };
              // },
              //    结构赋值语法三：
              props({ query: { id, title, a, b } }) {
                return {
                  id: id,
                  title: title,
                  a: a,
                  b: b,
                };
              },
            },
          ],
        },
      ],
    },
  ],
});
