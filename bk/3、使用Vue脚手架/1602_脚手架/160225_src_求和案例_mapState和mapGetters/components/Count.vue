<template>
  <div>
    <!-- <h1>当前求和为：{{ $store.state.sum }}</h1> -->
    <!-- <h1>当前求和为：{{ he }}</h1> -->
    <h1>当前求和为：{{ sum }}</h1>
    <!-- <h3>放大10倍为：{{ $store.getters.bigSum }}</h3> -->
    <!-- <h3>放大10倍为：{{ daHe }}</h3> -->
    <h3>放大10倍为：{{ bigSum }}</h3>
    <hr />
    <!-- <h3>国家：{{ $store.state.nation }}</h3> -->
    <!-- <h3>国家：{{ guojia }}</h3> -->
    <h3>国家：{{ nation }}</h3>
    <!-- <h3>城市：{{ $store.state.city }}</h3> -->
    <!-- <h3>城市：{{ chengshi }}</h3> -->
    <h3>城市：{{ city }}</h3>
    <hr />
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
import { mapState,mapGetters } from "vuex";
export default {
  name: "Count",
  data() {
    return {
      num: 1,
    };
  },
  computed: {
    /** 程序员自己写计算属性 */
    /**   从state中读取 */
    // he() {
    //   return this.$store.state.sum;
    // },
    // guojia() {
    //   return this.$store.state.nation;
    // },
    // chengshi() {
    //   return this.$store.state.city;
    // },
    /**   从getters中读取 */
    // dahe() {
    //   return this.$store.getters.bigSum;
    // },

    /** ******************************************************* */
    /** 借助mapState生成计算属性，从state中读取数据。（对象写法） */
    // ...mapState({ he: "sum", guojia: "nation", chengshi: "city" }),

    /** 借助mapState生成计算属性，从state中读取数据。（数组写法） */
    ...mapState(['sum','nation','city']),

    /** ******************************************************* */
    /** 借助mapGetters生成计算属性，从state中读取数据。（对象写法） */
    // ...mapGetters({ daHe: "bigSum"}),

    /** 借助mapGetters生成计算属性，从state中读取数据。（数组写法） */
    ...mapGetters(['bigSum']),
  },
  methods: {
    increment() {
      this.$store.commit("INCREMENT", this.num);
    },
    decrement() {
      this.$store.commit("DECREMENT", this.num);
    },
    incrementOdd() {
      this.$store.commit("INCREMENTODD", this.num);
    },
    incrementWait() {
      this.$store.dispatch("incrementWait", this.num);
    },
  },
  mounted() {
    const x = mapState({ he: "sum", guojia: "nation", chengshi: "city" });
    const y = mapGetters({ daHe: "bigSum"});
    /**
     * x => {
     *        he: mappedState() { ... },
     *        ...
     *      }
     * 生成的对象中的成员he也就是computed中的 he: function xxxxxx() { ... }
     */
    console.log(x);
    console.log(y);
  },
};
</script>

<style>
button {
  margin-left: 10px;
}
</style>
