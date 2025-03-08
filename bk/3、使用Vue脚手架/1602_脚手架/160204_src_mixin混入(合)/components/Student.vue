<template>
  <div id="student">
    <h2>{{ name }}</h2>
    <button @click="showName">显示名字</button>
  </div>
</template>

<script>
//分别暴露
//局部混入
// import { m, n } from "../mixin_common";
export default {
  name: "Student",
  data() {
    return {
      name: "xxxx学生",
    };
  },
  methods: {
    showName() {
      console.log(this.name);
    },
  },
  // mixins: [m,n],
};
</script>

<style>
#student {
  background-color: darkseagreen;
}
</style>
