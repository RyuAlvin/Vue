<template>
  <div id="app">
    <router-view></router-view>
    <tab-bar>
      <tab-bar-item link="/home">
        <img slot="item-img" src="~assets/img/tabbar/home.svg" alt=""/>
        <img slot="item-img-active" src="~assets/img/tabbar/home_active.svg" alt=""/>
        <div slot="item-text">首页</div>
      </tab-bar-item>
      <tab-bar-item link="/category">
        <img slot="item-img" src="~assets/img/tabbar/category.svg" alt=""/>
        <img slot="item-img-active" src="~assets/img/tabbar/category_active.svg" alt=""/>
        <div slot="item-text">分类</div>
      </tab-bar-item>
      <tab-bar-item link="/cart">
        <img slot="item-img" src="~assets/img/tabbar/shopcart.svg" alt=""/>
        <img slot="item-img-active" src="~assets/img/tabbar/shopcart_active.svg" alt=""/>
        <div slot="item-text">购物车</div>
      </tab-bar-item>
      <tab-bar-item link="profile">
        <img slot="item-img" src="~assets/img/tabbar/profile.svg" alt=""/>
        <img slot="item-img-active" src="~assets/img/tabbar/profile_active.svg" alt=""/>
        <div slot="item-text">我的</div>
      </tab-bar-item>
    </tab-bar>
  </div>
</template>

<script>
import TabBar from 'components/tabbar/TabBar'
import TabBarItem from 'components/tabbar/TabBarItem'
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
