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
export default {
  name: 'Home',
  components: {
    NavBar
  }
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