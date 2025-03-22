<template>
  <div>
    <nav-bar class="home-nav">
      <div slot="center">
        购物街
      </div>
    </nav-bar>
    <h2>主页</h2>
  </div>
</template>

<script>
import NavBar from '@/components/common/navBar/NavBar.vue';
import { getHomeMultiData } from '@/network/home';
export default {
  name: 'Home',
  data() {
    return {
      banners: [],
      recommends: []
    }
  },
  components: {
    NavBar
  },
  created() {
    /**
     * http://123.207.32.32:7888/api/hy66/home/multidata
     * 获取首页数据
     * 1、安装axios，生产依赖（运行时依赖）
     * 2、封装request.js，看axios官方文档
     * 3、创建network/home.js
     *      引入request.js
     *      关于首页所有的数据请求都封装在home.js
     * 4、在组件创建完成之后，调用异步请求获取数据
     * 5、请求到的数据放在this.data中
     */

     getHomeMultiData().then(res => {
      this.banners = res.data.banner.list;
      this.recommends = res.data.recommend.list;
     })
  },
}
</script>

<style>
.home-nav {
  /* 引用base.css中的变量 --color-tint: #ff8198; */
  background-color: var(--color-tint);
  color: #fff;
  font-weight: 700;
}
</style>