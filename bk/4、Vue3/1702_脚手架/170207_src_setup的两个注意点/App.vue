<template>
  <Demo @hello="sayHello" msg1="test01" msg2="test02">
    <h2 :slot="test">This is slot .</h2>
  </Demo>
</template>

<script>
import Demo from "./components/Demo.vue";
export default {
  name: "App",
  setup(props) {
    function sayHello(value) {
      alert(value);
    }
    return {
      sayHello,
    };
  },
  components: {
    Demo,
  },
};
</script>

<style></style>
