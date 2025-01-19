<template>
  <div>
    <h1>Hello, This is Home</h1>
    <router-link to="/home/news">新闻</router-link> <router-link to="/home/messages">消息</router-link>
    <router-view/>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>