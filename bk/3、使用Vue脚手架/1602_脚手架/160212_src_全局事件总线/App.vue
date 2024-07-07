<template>
  <div>
    <h1>{{ info }}</h1>
    <School />
    <Student />
  </div>
</template>

<script>
import School from "./components/School.vue";
import Student from "./components/Student.vue";
export default {
  name: "App",
  data() {
    return {
      info: "Hello World !",
    };
  },
  components: { School, Student },
};
</script>

<style>
div {
  background-color: #ddd;
  padding: 10px;
  margin-top: 10px;
  margin-bottom: 10px;
}
</style>
