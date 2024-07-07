<template>
  <div id="student">
    <h2>{{ name | mySlice }}</h2>
    <h2>{{ address }}</h2>
    <input type="number" v-fbind:value="number" />
  </div>
</template>

<script>
export default {
  name: "Student",
  data() {
    return {
      name: "xxxxxxxx大学",
      address: "东京",
      number: "100",
    };
  },
};
</script>

<style>
#student {
  background-color: cadetblue;
}
</style>
