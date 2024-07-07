<template>
  <div>
    <h1>人员信息：</h1>
    <input type="text" v-model="inputName" />
    <button @click="addPerson">添加</button>
    <button @click="addPersonWithFeng">只添加姓冯的人</button>
    <button @click="addWithAxios">axios请求随意添加一个人</button>
    <ul>
      <li v-for="person in personList" :key="person.id">{{ person.name }}</li>
    </ul>
    <h2 style="color: blue">排在第一个人的名字：{{ firstPersonName }}</h2>
    <h2>上面组件的和信息为：{{ sum }}</h2>
  </div>
</template>

<script>
import { nanoid } from "nanoid";
import { mapActions } from "vuex";
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
      this.$store.commit("personAbout/ADD_PERSON", {
        id: nanoid(),
        name: this.inputName,
      });
      this.inputName = "";
    },
    addPersonWithFeng() {
      if (!this.inputName.trim()) {
        this.inputName = "";
        return alert("输入有误！");
      }
      this.$store.dispatch("personAbout/addPersonWithFeng", {
        id: nanoid(),
        name: this.inputName,
      });
      this.inputName = "";
    },
    addWithAxios() {
      this.$store.dispatch("personAbout/addWithAxios");
    },
  },
  computed: {
    personList() {
      return this.$store.state.personAbout.personList;
    },
    sum() {
      return this.$store.state.countAbout.sum;
    },
    firstPersonName() {
      return this.$store.getters["personAbout/firstPersonName"];
    },
  },
  mounted() {
    console.log(this);
  },
};
</script>

<style scoped>
ul {
  margin-top: 10px;
}
</style>
