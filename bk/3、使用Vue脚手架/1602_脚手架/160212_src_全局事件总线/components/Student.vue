<template>
  <div id="student">
    <h2>Student组件：{{ name }}</h2>
    <button @click="sendToSchool">给School组件传递数据</button>
  </div>
</template>

<script>
export default {
  name: "Studnet",
  data() {
    return {
      name: "ryu",
    };
  },
  methods: {
    sendToSchool() {
      this.$bus.$emit("studentToSchool", this.name);
    },
  },
};
</script>

<style scoped>
#student {
  height: 100px;
  background-color: darkcyan;
}
</style>
