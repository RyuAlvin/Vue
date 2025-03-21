<template>
  <div id="main-tab-bar">
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
      <tab-bar-item link="/profile">
        <img slot="item-img" src="~assets/img/tabbar/profile.svg" alt=""/>
        <img slot="item-img-active" src="~assets/img/tabbar/profile_active.svg" alt=""/>
        <div slot="item-text">我的</div>
      </tab-bar-item>
    </tab-bar>
  </div>
</template>

<script>
/**
 * TabBar导入顺序和注意点：
 * 1、资源导入
 *    a、 TabBar.vue -> components/common
 *        TabBarItem.vue -> components/common
 *    b、 各Tab的View文件
 *    c、 各图标的svg文件
 * 
 * 2、创建MainTabBar.vue -> components/content
 *    a、 导入TabBar、TabBarItem
 *    b、 嵌套顺序：MainTabBar 包含 TabBar.vue 包含 TabBarItem.vue
 *    c、 静态资源引入路径更改
 *    
 * 3、安装vue-router，生产依赖（运行时需要）
 *    a、 npm install vue-router --save
 * 
 * 4、router/index.js
 *    a、 导入Vue、Router
 *    b、 Vue使用插件Router
 *    c、 动态导入（按需加载）试图
 *    d、 创建Router对象，并默认导出
 *        设置routes对象数组，指定各个route的path和component
 *        指定路由模式
 * 
 * 5、App.vue
 *    a、 导入<router-view></router-view>
 *    b、 导入<main-tab-bar></main-tab-bar>
 * 
 * 注意点：
 * 1、通用组件（可移植至别的项目）放components/common
 * 2、业务组件（由该项目定制）放components/content
 * 3、关于路径中的 ~
 *    需要加 ~ 的场景：在<template>和<style>（css）中引用静态资源
 */
import TabBar from 'components/common/tabBar/TabBar.vue';
import TabBarItem from 'components/common/tabBar/TabBarItem.vue';
export default {
  name: 'MainTabBar',
  components: {
    TabBar,
    TabBarItem
  }
}
</script>

<style>

</style>