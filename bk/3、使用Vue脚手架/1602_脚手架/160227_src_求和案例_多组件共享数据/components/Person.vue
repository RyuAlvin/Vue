<template>
  <div>
    <h1>人员信息：</h1>
    <input type="text" v-model="inputName" />
    <button @click="addPerson">添加</button>
    <ul>
      <li v-for="person in personList" :key="person.id">{{ person.name }}</li>
    </ul>
    <h2>上面组件的和信息为：{{sum}}</h2>
  </div>
</template>

<script>
import { nanoid } from "nanoid";
export default {
  name: "Person",
  data() {
    return {
      inputName: "",
    };
  },
  methods: {
    addPerson() {
      if (!this.inputName.trim()) {
        this.inputName = "";
        return alert("输入有误！");
      }
      this.personList.unshift({ id: nanoid(), name: this.inputName });
      this.inputName = "";
    },
  },
  computed: {
    personList() {
      return this.$store.state.personList;
    },
    sum(){
        return this.$store.state.sum;
    }
  },
};
</script>

<style>
ul {
  margin-top: 10px;
}
</style>
