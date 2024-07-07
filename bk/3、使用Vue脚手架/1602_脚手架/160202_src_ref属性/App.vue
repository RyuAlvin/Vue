<template>
  <div>
    <School ref="school" />
    <h2 ref="info">info：{{ info }}</h2>
    <button ref="btn" @click="changeEleTest">通过ref操作HTMLElement</button>
  </div>
</template>

<script>
import School from "./components/School.vue";
export default {
  name: "App",
  components: {
    School,
  },
  data() {
    return {
      info: "ref属性学习",
    };
  },
  methods: {
    changeEleTest() {
      console.log(this.$refs.school) //School组件的实例对象（vc）
      console.log(this.$refs.info) //真实DOM元素
      console.log(this.$refs.btn) //真实DOM元素
    },
  },
};
</script>

<style></style>
