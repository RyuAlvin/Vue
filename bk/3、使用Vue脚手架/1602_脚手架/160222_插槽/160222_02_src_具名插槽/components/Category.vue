<template>
  <div class="category">
    <h3>{{ title }}分类</h3>
    <!-- <ul>
      <li v-for="(item, index) in this.list" :key="index">{{ item }}</li>
    </ul> -->
    <slot name="center"><h1>center插槽</h1></slot>
    <slot name="footer"><h1>footer插槽</h1></slot>
  </div>
</template>

<script>
export default {
  name: "Cateory",
  props: ["title"],
};
</script>

<style scoped>
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
