<template>
  <div>
    <h1>当前求和为：{{ $store.state.sum }}</h1>
    <select v-model.number="num">
      <!-- 
        通过v-bind语法，value的值都是js表达式，那么就会是数字类型
        <option :value="1">1</option> 
        -->
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>
      <option value="4">4</option>
      <option value="5">5</option>
    </select>
    <button @click="increment">+</button>
    <button @click="decrement">-</button>
    <button @click="incrementOdd">奇数再加</button>
    <button @click="incrementWait">等一会儿再加</button>
  </div>
</template>

<script>
export default {
  name: "Count",
  data() {
    return {
      num: 1,
    };
  },
  methods: {
    increment() {
      // this.$store.dispatch("increment", this.num);
      // 若没有网络请求或其他业务逻辑，组件中也可以越过actions，即不写dispatch，直接编写commit
      this.$store.commit("INCREMENT",this.num)
    },
    decrement() {
      // this.$store.dispatch("decrement", this.num);
      this.$store.commit("DECREMENT",this.num)
    },
    incrementOdd() {
      // this.$store.dispatch("incrementOdd", this.num);
      this.$store.commit("INCREMENTODD", this.num);
    },
    incrementWait() {
      this.$store.dispatch("incrementWait", this.num);
      // this.$store.commit("INCREMENTODD", this.num);
    },
  },
};
</script>

<style>
button {
  margin-left: 10px;
}
</style>
