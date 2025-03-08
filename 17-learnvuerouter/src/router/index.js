import Vue from 'vue'
import Router from 'vue-router'
// import Home from '../components/Home.vue'
// import About from '../components/About.vue'
// import User from '../components/User.vue'

// 以下为懒加载组件。作用是按需加载组件，而不是在应用启动时一次性加载所有组件。
const Home = () => import('../components/Home.vue')
const About = () => import('../components/About.vue')
const User = () => import('../components/User.vue')
const HomeNews = () => import('../components/HomeNews.vue')
const HomeMessages = () => import('../components/HomeMessages.vue')
const Profile = () => import('../components/Profile.vue')

Vue.use(Router)

const routes = [
  {
    path: '',
    redirect: '/home'
  },
  {
    path: '/home',
    component: Home,
    meta: {
      title: '主页'
    },
    children: [
      {
        path: '/home',
        redirect: 'news'
      },
      {
        path: 'news',
        component: HomeNews
      },
      {
        path: 'messages',
        component: HomeMessages
      }
    ]
  },
  {
    path: '/about',
    component: About,
    meta: {
      title: '关于'
    }
  },
  {
    // :userId，定义路由参数名
    path: '/user/:userId',
    component: User,
    meta: {
      title: '用户'
    }
  },
  {
    path: '/profile',
    component: Profile,
    meta: {
      title: '简介'
    },
    beforeEnter: (to, from, next) => {
      // console.log('=======');
      next();
    }
  }
]

// export default new Router({
//   routes,
//   mode: 'history',
//   // 为避免批量修改active-class，可在router/index.js中一次性更改 
//   linkActiveClass: 'active'
// })

const router = new Router({
  routes,
  mode: 'history',
  // 为避免批量修改active-class，可在router/index.js中一次性更改 
  linkActiveClass: 'active'
})

// 全局导航守卫（前置钩子）
router.beforeEach((to, from ,next) => {
  // console.log('++++++');
  document.title = to.matched[0].meta.title;
  next();
})

// 全局导航守卫（后置钩子）
router.afterEach((to, from ,next) => {
  // console.log('------');
})

export default router;

/**
 * router/index.js
 * 1、导入vue-router
 * 2、Vue.use(Router)注册全局插件
 * 3、导入各组件
 * 4、像new Vue({})一样，new Router({})
 * 5、指定各路由对象{ path: '', component: ''}
 * 6、指定初始路由{ path: '', redirect: '/homoe'}
 * 7、通过mode指定模式（url的hash模式或html5的history模式）
 *    url的hash模式：
 *      a、url结构：
 *          http://example.com/#/about
 *          #之后的部分（/about）是前端路由控制的部分，浏览器不会将其发送到服务器
 *      b、工作原理：
 *          依赖window.location.hash监听url变化
 *          windows.addEventListener("hashchange", () => {
 *            console.log("当前 hash：", location.hash);
 *          })
 *          hash变化不会导致页面刷新，适用于SPA（单页应用）
 *      c、特点：
 *          兼容性好，支持所有浏览器，包括旧版IE；
 *          无需服务器支持，即使用户刷新页面，也不会404；
 *          URL不美观，带#符号，不符合SEO（搜索引擎优化）；
 *      d、使用JS进行hash路由跳转：
 *          location.hash = '#/home';
 *    html5的history模式：
 *      a、ur结构：
 *          http://example.com/about
 *          没有#，url更加美观，类似传统的RESTful路由
 *      b、工作原理：
 *          依赖history.pushState()和history.replaceState()修改url：
 *            history.pushState(null, '', '/about'); // 改变url
 *          监听popstate事件，处理前进/后退：
 *            window.addEventListener('popstate', (event) => {
 *              console.log('url 变更：', location.pathname);
 *            })
 *      c、特点：
 *          旧版IE不支持；
 *          url结构友好，无#，支持SEO；
 *          可以使用pushState维护历史记录，前进/后退体验更流畅；
 *          需要后端支持，否则刷新页面会404（因为服务器找不到这个路径）；
 *      d、示例：
 *          history.pushState({ page: 'about' }, '', '/about');
 * 8、导出
 * 
 * main.js
 * 1、导入router/index.js
 * 2、设置Vue实例的router属性
 * 
 * App.vue
 * 1、<router-link></router-link>组件指定路由（to属性）
 * 2、<router-view></router-view>占位，用于切换不同组件
 */