<template>
  <div>
    <h1>Hello, This is User</h1>
    <!-- <h1>当前用户：{{ userId }}</h1> -->
     <!-- $route指向当前被激活的路由 -->
    <h1>当前用户：{{ $route.params.userId }}</h1>
  </div>
</template>

<script>
export default {
  // computed:{
  //   /**
  //    * 接收参数
  //    */
  //   userId() {
  //     return this.$route.params.userId;
  //   }
  // }
  beforeRouteEnter (to, from, next) {
    console.log('Hello User...');
    next();
  },
  beforeRouteLeave (to, from, next) {
    console.log('Bye User...');
  }
}
</script>

<style>

</style>