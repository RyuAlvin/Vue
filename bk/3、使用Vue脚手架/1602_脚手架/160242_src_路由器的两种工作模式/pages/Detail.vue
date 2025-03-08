<template>
  <ul>
    <!-- 接收参数 -->
    <li>消息 id：{{ id }}</li>
    <li>消息 title：{{ title }}</li>
  </ul>
</template>

<script>
export default {
  name: "Detail",
  props: ["id", "title"],
};
</script>

<style></style>
