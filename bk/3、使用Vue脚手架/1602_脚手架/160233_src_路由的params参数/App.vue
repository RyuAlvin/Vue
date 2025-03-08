<template>
  <div>
    <div class="row">
      <div class="col-xs-offset-2 col-xs-8">
        <Banner />
      </div>
    </div>
    <div class="row">
      <div class="col-xs-2 col-xs-offset-2">
        <div class="list-group">
          <!-- <router-link class="list-group-item" active-class="active" to="/About">About</router-link> -->
          <!-- 虽然可以通过【命名路由+to的对象写法】来定义跳转，但是没必要，在这里直接写path更直观明了 -->
          <router-link
            class="list-group-item"
            active-class="active"
            :to="{ name: 'guanyu' }"
            >About</router-link
          >
          <router-link class="list-group-item" active-class="active" to="/Home"
            >Home</router-link
          >
        </div>
      </div>
      <div class="col-xs-6">
        <div class="panel">
          <div class="panel-body">
            <router-view></router-view>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Banner from "./components/Banner.vue";
export default {
  name: "App",
  components: {
    Banner,
  },
};
</script>

<style></style>
