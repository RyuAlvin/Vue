<template>
  <h1>{{ title }}</h1>
  <h2>{{ name }}</h2>
  <h2>{{ age }}</h2>
  <button @click="sayHello">sayHello</button>
</template>

<script>
import { h } from "vue";
export default {
  name: "App",
  /**
   * 1、Vue3.0中一个新的配置项，值为一个函数；
   * 2、setup是所有Composition API(组合API)"表演的舞台"；
   * 3、组件中所用到的：数据、方法等等，均要配置在setup中；
   * 4、setup函数的两种返回值：
   *    a、若返回一个对象，则对象中的属性、方法，在模版中均可以直接使用；(重点关注)
   *    b、若返回一个渲染函数：则可以自定义渲染内容；(了解)
   *        import { h } from "vue";
   *        setup() { return () => h("h1", "直接渲染！"); }
   * 5、注意点：
   *    a、尽量不要与Vue2.x配置混用；
   *        - Vue2.x配置(data、methods、computed...)中可以访问到setup中的属性、方法；
   *        - 但在setup中不能访问到Vue2.x配置(data、method是、computed...)；
   *        - 如果有重名，setup优先；
   *    b、setup不能是一个async函数，因为返回值不再是return的对象，而是promis，模版看不到return对象中的属性。
   *        (后期也可以返回一个Promise实例，但需要Suspense和异步组件的配合)
   */
  setup() {
    let title = "个人信息";
    let name = "Ryu";
    let age = 18;
    function sayHello() {
      console.log(name, "@@@@", age);
    }
    return () => h("h1", "直接渲染！");
  },
};
</script>

<style></style>
