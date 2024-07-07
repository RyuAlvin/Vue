<template>
  <div>
    <h2>下面组件的人员信息长度为：{{ personList.length }}</h2>
    <h1>当前求和为：{{ sum }}</h1>
    <h3>放大10倍为：{{ bigSum }}</h3>
    <h3>国家：</h3>
    <h3>城市：</h3>
    <select v-model.number="num">
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>
      <option value="4">4</option>
      <option value="5">5</option>
    </select>
    <button @click="INCREMENT(num)">+</button>
    <button @click="DECREMENT(num)">-</button>
    <!-- 不用传参的写法 -->
    <button @click="demo">奇数再加</button>
    <button @click="incrementWait(num)">等一会儿再加</button>
  </div>
</template>

<script>
import { mapActions, mapMutations, mapState, mapGetters } from "vuex";
export default {
  name: "Count",
  data() {
    return {
      num: 1,
    };
  },
  methods: {
    demo() {
      this.incrementOdd(this.num);
    },
    ...mapMutations(["INCREMENT", "DECREMENT"]),
    ...mapActions(["incrementOdd", "incrementWait"]),
  },
  computed: {
    ...mapState(["sum", "personList"]),
    ...mapGetters(["bigSum"]),
  },
};
</script>

<style>
button {
  margin-left: 10px;
}
</style>
