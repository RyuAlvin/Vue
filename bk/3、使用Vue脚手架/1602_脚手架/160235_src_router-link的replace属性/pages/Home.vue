<template>
  <div>
    <h2>Home组件内容</h2>
    <div>
      <ul class="nav nav-tabs">
        <li>
          <!-- 
            <router-link>的replace属性：
              1、作用：控制路由跳转时操作浏览器历史记录的模式；
              2、浏览器的历史记录由两种写入方式：分别为push和replace，
                  push是追加历史记录，replace是替换当前记录。
                  路由跳转时默认为push；
              3、如何开启replace模式：
                  写法一：
                  <router-link replace ...>News</router-link>
                  写法二：
                  <router-link :replace="true" ...>News</router-link>
           -->
          <router-link
            :replace="true"
            class="list-group-item"
            active-class="active"
            to="/Home/News"
            >News</router-link
          >
        </li>
        <li>
          <router-link
            replace=""
            class="list-group-item"
            active-class="active"
            to="/Home/Message"
            >Message</router-link
          >
        </li>
      </ul>
      <div>
        <router-view></router-view>
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
