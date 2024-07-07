<template>
  <h1>{{ title }}</h1>
  <h2>{{ name }}</h2>
  <h2>{{ age }}</h2>
  <h1>对象数据</h1>
  <h2>{{ obj.a }}</h2>
  <h2>{{ obj.b }}</h2>
  <button @click="changeData">更改数据</button>
</template>

<script>
/**
 * ref函数：
 *  1、作用：定义一个响应式的数据；
 *  2、语法：const xxx = ref(initValue)
 *      - 创建一个包含响应式数据的引用对象(reference对象，简称ref对象)；
 *      - JS中操作数据：xxx.value
 *      - 模版中读取数据：不需要.value，直接：<div>{{ xxx }}</div>
 *  3、备注：
 *      - 接收的数据可以是：基本类型、也可以是对象类型；
 *      - 基本类型的数据：响应式依然是靠object.defineProperty()的get与set完成的；
 *      - 对象类型的数据：内部"求助"了Vue3.0中的一个函数--reactive函数；
 */
import { ref } from "vue";
export default {
  name: "App",
  setup() {
    let title = "个人信息";
    let name = ref("Ryu");
    let age = ref(18);
    const obj = ref({ a: 1, b: 2 });
    function changeData() {
      name.value = "sBen";
      age.value = 30;
      obj.value.a = 10;
      obj.value.b = 20;
    }
    return {
      title,
      name,
      age,
      obj,
      changeData,
    };
  },
};
</script>

<style></style>
