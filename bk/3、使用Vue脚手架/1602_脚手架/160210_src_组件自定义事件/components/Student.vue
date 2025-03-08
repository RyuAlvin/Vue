<template>
  <div id="student">
    <h2>number：{{ number }}</h2>
    <h2>name：{{ name }}</h2>
    <button @click="add">数字递增</button>
    <button @click="sendStudentName">显示学生名字</button>
    <button @click="offRyu">销毁ryu事件</button>
    <button @click="offAll">销毁所有事件</button>
    <button @click="gotoDie">销毁Student组件实例(vc)</button>
  </div>
</template>

<script>
export default {
  name: "Studnet",
  data() {
    return {
      name: "ryu",
      number: 0,
    };
  },
  methods: {
    add() {
      console.log("add回调函数被调用了");
      this.number++;
    },
    sendStudentName() {
      // 触发Student组件实例身上的【ryu】事件
      this.$emit("ryu", this.name, "aaa", 111, true);
      this.$emit("alvin");
    },
    offRyu() {
      this.$off("ryu");
    },
    offAll() {
      this.$off(["ryu", "alvin"]);
      //   this.$off(); //暴力解除所有
    },
    gotoDie() {
      this.$destroy();
    },
  },
};
</script>

<style scoped>
#student {
  height: 150px;
  background-color: darkcyan;
}
</style>
