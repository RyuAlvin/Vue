<template>
  <div>
    <button @click="getStudents">获取数据</button>
  </div>
</template>

<script>
// npm i axios
import axios from "axios";
export default {
  name: "App",
  methods: {
    getStudents() {
      axios.get("http://localhost:8080/students").then(
        (response) => {
          console.log("请求成功了！ -- " + response.data);
        },
        (error) => {
          console.log("请求失败了！ -- " + error.message);
        }
      );
    },
  },
};
</script>

<style></style>
