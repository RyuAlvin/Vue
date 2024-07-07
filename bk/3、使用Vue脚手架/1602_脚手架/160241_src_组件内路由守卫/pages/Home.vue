<template>
  <div>
    <h2>Home组件内容</h2>
    <div>
      <ul class="nav nav-tabs">
        <li>
          <router-link
            class="list-group-item"
            active-class="active"
            to="/Home/News"
            >News</router-link
          >
        </li>
        <li>
          <router-link
            class="list-group-item"
            active-class="active"
            to="/Home/Message"
            >Message</router-link
          >
        </li>
      </ul>
      <div>
        <!-- 
          缓存路由组件：
            让不展示的路由组件保持挂载，不被销毁
            <router-view>中包含了两个组件，Message和News
              inclue属性是只设置News组件为缓存路由组件。
         -->
        <!-- 缓存单个路由组件 -->
        <!-- <keep-alive include="News">
          <router-view></router-view>
        </keep-alive> -->

        <!-- 缓存多个路由组件 -->
        <keep-alive :include="['News', 'Message']">
          <router-view></router-view>
        </keep-alive>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home",
};
</script>

<style></style>
