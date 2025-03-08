<template>
  <div id="app">
    <h1>{{ info }}</h1>
    <School />
    <Student />
  </div>
</template>

<script>
import Student from "./components/Student.vue";
import School from "./components/School.vue";
export default {
  name: "App",
  data() {
    return {
      info: "mixin混入",
    };
  },
  components: {
    Student,
    School,
  },
};
</script>

<style></style>
