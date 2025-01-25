<template>
  <div>
    <h1>Hello, This is Home</h1>
    <router-link to="/home/news">新闻</router-link> <router-link to="/home/messages">消息</router-link>
    <router-view/>
  </div>
</template>

<script>
export default {
  /**
   * 通过<keep-alive>包裹的组件在切换时不会被销毁，而是保留其状态，提高性能。
   * 可通过以下created和destroyed两个钩子函数观察证明。
   *  created只会被执行一次，在来回切换组件的时候，destroyed不会被执行。
   */
  created() {
    console.log('Home cpn is created...');
  },
  destroyed() {
    console.log('Home cpn is destroyed...');
  },
}
</script>

<style>

</style>