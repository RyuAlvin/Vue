<template>
  <ul>
    <!-- 接收参数 -->
    <li>message的id：{{id}}</li>
    <li>message的title：{{title}}</li>
    <li>a：{{a}}</li>
    <li>b：{{b}}</li>
  </ul>
</template>

<script>
export default {
    name:'Detail',
    props:['id','title','a','b']
}
</script>

<style>

</style>