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
              path: "Detail",
              component: Detail,
            },
          ],
        },
      ],
    },
  ],
});
