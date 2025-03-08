<template>
  <div>
    <h2 class="demo">{{ name }}</h2>
    <h2>{{ city }}</h2>
  </div>
</template>

<script>
  export default {
    name: "School",
    data() {
      return {
        name: "xxxx大学",
        city: "东京",
      };
    },
  };
</script>

<style>
  .demo {
    background-color: cornflowerblue;
  }
</style>
