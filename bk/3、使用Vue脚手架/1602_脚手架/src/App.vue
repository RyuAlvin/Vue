<template>
  <div>
    <h2>姓名：{{ person.name }}</h2>
    <h2>年龄：{{ person.age }}</h2>
    <h2 v-show="person.sex">性别：{{ person.sex }}</h2>
    <h2>兴趣：{{ person.hobby }}</h2>
    <hr />
    <button @click="updateName">修改name属性</button>
    <button @click="addSex">添加sex属性</button>
    <button @click="deleteName">删除name属性</button>
    <hr />
    <button @click="updateArr">修改数组</button>
  </div>
</template>

<script>
import Vue from "vue";
export default {
  name: "App",
  data() {
    return {
      person: {
        name: "Ryu",
        age: 20,
        hobby: ["抽烟", "喝酒", "烫头"],
      },
    };
  },
  methods: {
    updateName() {
      this.person.name = "sBen";
    },
    addSex() {
      // 方式一：
      // Vue.set(this.person, "sex", "男");
      // 方式二：
      this.$set(this.person, "sex", "男");
    },
    deleteName() {
      // Vue.delete(this.person, "name");
      this.$delete(this.person, "name");
    },
    updateArr() {
      console.log(this.person.hobby);
      this.person.hobby.splice(0, 1, "学习");
      console.log(this.person.hobby);
    },
  },
};
</script>

<style scoped>
button {
  margin-left: 10px;
}
</style>
