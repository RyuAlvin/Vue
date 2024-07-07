<template>
  <div id="school">
    <h2>学校名字：{{ name }}</h2>
    <h2>学校地址：{{ address }}</h2>
  </div>
</template>

<script>
export default {
  name: "School",
  data() {
    return {
      info: "Hello World",
      name: "xxxx大学",
      address: "东京",
    };
  },
};
</script>

<style>
#school {
  background-color: bisque;
}
</style>
