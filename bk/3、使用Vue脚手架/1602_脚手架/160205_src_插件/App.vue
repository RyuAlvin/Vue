<template>
  <div>
    <Student />
  </div>
</template>

<script>
import Student from "./components/Student.vue";
export default {
  name: "App",
  data() {
    return {
      info: "插件",
    };
  },
  components: {
    Student,
  },
};
</script>

<style></style>
