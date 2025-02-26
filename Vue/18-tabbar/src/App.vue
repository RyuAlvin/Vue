<template>
  <div id="app">
    <tab-bar>
      <tab-bar-item>
        <img slot="item-img" src="./assets/img/tabbar/home.png" alt=""/>
        <img slot="item-img-active" src="./assets/img/tabbar/home_active.png" alt=""/>
        <div slot="item-text">首页</div>
      </tab-bar-item>
      <tab-bar-item>
        <img slot="item-img" src="./assets/img/tabbar/category.png" alt=""/>
        <img slot="item-img-active" src="./assets/img/tabbar/category_active.png" alt=""/>
        <div slot="item-text">分类</div>
      </tab-bar-item>
      <tab-bar-item>
        <img slot="item-img" src="./assets/img/tabbar/cart.png" alt=""/>
        <img slot="item-img-active" src="./assets/img/tabbar/cart_active.png" alt=""/>
        <div slot="item-text">购物车</div>
      </tab-bar-item>
      <tab-bar-item>
        <img slot="item-img" src="./assets/img/tabbar/profile.png" alt=""/>
        <img slot="item-img-active" src="./assets/img/tabbar/profile_active.png" alt=""/>
        <div slot="item-text">我的</div>
      </tab-bar-item>
    </tab-bar>
  </div>
</template>

<script>
import TabBar from './components/tabbar/TabBar'
import TabBarItem from './components/tabbar/TabBarItem'
export default {
  name: 'App',
  components: {
    TabBar,
    TabBarItem
  }
}
</script>

<style>
@import "./assets/css/base.css";
</style>
