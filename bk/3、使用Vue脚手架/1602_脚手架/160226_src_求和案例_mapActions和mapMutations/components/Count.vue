<template>
  <div>
    <h1>当前求和为：{{ sum }}</h1>
    <h3>放大10倍为：{{ bigSum }}</h3>
    <hr />
    <h3>国家：{{ nation }}</h3>
    <h3>城市：{{ city }}</h3>
    <hr />
    <select v-model.number="num">
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>
      <option value="4">4</option>
      <option value="5">5</option>
    </select>
    <!-- <button @click="increment(num)">+</button> -->
    <button @click="INCREMENT(num)">+</button>
    <!-- <button @click="demo1">+</button> -->
    <!-- <button @click="decrement">-</button> -->
    <button @click="DECREMENT(num)">-</button>
    <button @click="incrementOdd(num)">奇数再加</button>
    <button @click="incrementWait(num)">等一会儿再加</button>
  </div>
</template>

<script>
import { mapState, mapGetters, mapMutations, mapActions } from "vuex";
export default {
  name: "Count",
  data() {
    return {
      num: 1,
    };
  },
  computed: {
    ...mapState(["sum", "nation", "city"]),
    ...mapGetters(["bigSum"]),
  },
  methods: {
    /**
     * mapActions与mapMutations使用时，若需要传递参数需要：在模版中绑定事件时传递好参数，否则参数是事件对象。
     */
    
    /** 程序员自己写方法 */
    // increment() {
    //   this.$store.commit("INCREMENT", this.num);
    // },
    // decrement() {
    //   this.$store.commit("DECREMENT", this.num);
    // },

    /** ********************************************** */

    /**
     * 下面生成后的代码为：
     *  increment(value) {
     *    this.$store.commit("INCREMENT", value);
     *  }
     * 但是increment在元素中不指定参数的情况下，默认参数是event，解决办法：
     *  1、在事件中指定参数；
     *  2、再写一个方法，在方法中调用生成的方法，如下：
     */
    // ...mapMutations({ increment: "INCREMENT", decrement: "DECREMENT" }),
    // demo1() {
    //   this.increment(this.num);
    // },

    /** 借助mapMutations生成对应的方法，方法中会调用commit去联系mutations。（对象写法） */
    // ...mapMutations({ increment: "INCREMENT", decrement: "DECREMENT" }),

    /** 借助mapMutations生成对应的方法，方法中会调用commit去联系mutations。（数组写法） */
    ...mapMutations(["INCREMENT", "DECREMENT"]),

    /** ********************************************** */
    /** 程序员自己写方法 */
    // incrementOdd() {
    //   this.$store.dispatch("INCREMENTODD", this.num);
    // },
    // incrementWait() {
    //   this.$store.dispatch("incrementWait", this.num);
    // },

    /** ********************************************** */
    ...mapActions(["incrementOdd", "incrementWait"]),
  },
  mounted() {
  },
};
</script>

<style>
button {
  margin-left: 10px;
}
</style>
