<template>
  <div>
    <h1 class="Cpn">我是Cpn</h1>
    <p>{{ message }}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      message: "我是Cpn的内容",
    };
  },
};
</script>

<style>
.Cpn {
  background-color: orange;
}
</style>