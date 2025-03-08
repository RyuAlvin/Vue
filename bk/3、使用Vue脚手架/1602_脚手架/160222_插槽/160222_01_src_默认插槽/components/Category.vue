<template>
  <div class="category">
    <h3>{{ title }}分类</h3>
    <!-- <ul>
      <li v-for="(item, index) in this.list" :key="index">{{ item }}</li>
    </ul> -->
    <slot><h1>如果没有插槽的话就显示这个吧</h1></slot>
  </div>
</template>

<script>
export default {
  name: "Cateory",
  props: ["title"],
};
</script>

<style>
.category {
  background-color: skyblue;
  width: 200px;
  height: 300px;
}
h3 {
  text-align: center;
  background-color: orange;
}
</style>
