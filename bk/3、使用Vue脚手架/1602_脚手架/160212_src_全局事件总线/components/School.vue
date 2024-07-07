<template>
  <div id="school">
    <h2>School组件：{{ name }}</h2>
    <h2>从Student组件传递过来的值：{{ receiveVal }}</h2>
  </div>
</template>

<script>
export default {
  name: "School",
  data() {
    return {
      name: "xxxx大学",
      receiveVal: "",
    };
  },
  methods: {
    studentToSchool(value) {
      this.receiveVal = value;
    },
  },
  mounted() {
    this.$bus.$on("studentToSchool", this.studentToSchool);
  },
  beforeDestroy() {
    this.$bus.$off("studentToSchool");
  },
};
</script>

<style scoped>
#school {
  height: 100px;
  background-color: cornflowerblue;
}
</style>
