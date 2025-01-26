<template>
  <div>
    <h1>Hello, This is Home</h1>
    <router-link to="/home/news">新闻</router-link> <router-link to="/home/messages">消息</router-link>
    <router-view/>
  </div>
</template>

<script>
export default {
  data() {
    return {
      path:'/home/news'
    }
  },
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
  // 在离开前记住当前路径
  beforeRouteLeave (to, from, next) {
    this.path = this.$route.path;
    console.log('Home path ---> ', this.path);
    next();
  },
  /**
   * activated 和 deactivated 是 Vue 组件的生命周期钩子，它们主要用于 keep-alive 组件。
   * keep-alive 组件中生效，用于缓存组件而不销毁，适用于 Tab 切换、列表缓存等场景。
   */
  // 当组件被 激活（进入可见状态） 时触发
  activated(){
    console.log('Home activated...');
    if(this.path !== this.$route.path) {
      this.$router.push(this.path);
    }
  },
  // 当组件被 停用（离开可见状态） 时触发。
  deactivated(){
    console.log('Home deactivated...');
  }
}
</script>

<style>

</style>