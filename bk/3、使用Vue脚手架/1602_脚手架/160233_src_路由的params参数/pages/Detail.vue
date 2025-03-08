<template>
  <ul>
    <!-- 接收参数 -->
    <li>message的id：{{$route.params.id}}</li>
    <li>message的title：{{$route.params.title}}</li>
  </ul>
</template>

<script>
export default {
    name:'Detail'
}
</script>

<style>

</style>