<template>
  <ul>
    <!-- 接收参数 -->
    <li>message的id：{{$route.query.id}}</li>
    <li>message的title：{{$route.query.title}}</li>
  </ul>
</template>

<script>
export default {
    name:'Detail'
}
</script>

<style>

</style>