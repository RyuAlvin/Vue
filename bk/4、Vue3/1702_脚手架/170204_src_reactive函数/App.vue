<template>
  <h1>个人信息</h1>
  <h2>Name：{{ person.name }}</h2>
  <h2>Age：{{ person.age }}</h2>
  <h2>Hobby：{{ person.hobby }}</h2>
  <h1>工作信息</h1>
  <h2>Type：{{ person.job.type }}</h2>
  <h2>Salary：{{ person.job.salary }}</h2>
  <h2>Department name：{{ person.job.department.name }}</h2>
  <button @click="changeData">更改数据</button>
</template>

<script>
/**
 * reactive函数：
 *  1、作用：定义一个对象类型的响应式数据（基本类型不要用它，要用ref函数）；
 *  2、语法：const 代理对象 = reactive(源对象)接收一个对象（或数据），返回一个代理对象(Proxy的实例对象，简称proxy对象)
 *  3、reactive定义的响应式数据是"深层次的"；
 *  4、内部给予ES6的Proxy实现，通过代理对象操作源对象内部数据，进行操作；
 */
import { reactive } from "vue";
export default {
  name: "App",
  setup() {
    let person = reactive({
      name: "Ryu",
      age: 18,
      hobby: ["抽烟", "喝酒", "汤头"],
      job: {
        type: "IT",
        salary: "3000",
        department: {
          name: "dev",
        },
      },
    });
    function changeData() {
      person.name = "sBen";
      person.age = 60;
      person.hobby[0] = "学习";
      person.job.department.name = "test";
    }
    return {
      person,
      changeData,
    };
  },
};
</script>

<style></style>
