<template>
  <div class="demo">
    <h2>{{ name }}</h2>
  </div>
</template>

<script>
export default {
  name: "Student",
  data() {
    return {
      name: "Ryu"
    };
  },
};
</script>

<style>
.demo {
  background-color: skyblue;
}
</style>
