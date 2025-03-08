<template>
  <h1>{{ title }}</h1>
  <button @click="sayHi">sayHi</button>
  <slot name="test"></slot>
</template>

<script>
export default {
  name: "Demo",
  props: ["msg1", "msg2"],
  emits: ["hello"],
  setup(props, context) {
    /**
     * setup执行的时机，在beforeCreate之前执行一次，this是undefines
     */
    // console.log("setup", this);
    let title = "setup的两个注意点";

    /**
     * 父组件App通过标签属性传递了msg1和msg2，
     *  如果子组件Demo没有通过props配置接收的话，在setup的props参数中是不会显示的，
     *  有接收的情况，setup的props参数中会显示。
     * props参数是一个Proxy的实例对象，
     *  包含：组件外部传递过来，且组件内部声明接收了的属性。
     */
    // console.log(props);

    /**
     * context中的attrs为Proxy实例对象，
     *  包含：组件外部传递过来，但没有在props配置中声明的属性，相当于this.$attrs；
     */
    // console.log(context.attrs.msg3);

    /**
     * emit：分发自定义事件的函数，相当于this.$emit
     */
    function sayHi() {
      context.emit("hello", "Hello World");
    }

    return {
      title,
      sayHi,
    };
  },
  beforeCreate() {
    // console.log("beforeCreate");
  },
  mounted() {
    // console.log(this);
  },
};
</script>

<style></style>
