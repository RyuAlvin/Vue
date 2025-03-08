<template>
  <div class="category">
    <h3>{{ title }}</h3>
    <slot name="scopeSlot" :listData="games" msg="Hello World!">
      <h1>这是作用域插槽</h1>
    </slot>
  </div>
</template>

<script>
export default {
  name: "Cateory",
  props: ["title"],
  data() {
    return {
      games: ["红色警戒", "穿越火线", "劲舞团", "超级玛丽"],
    };
  },
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
