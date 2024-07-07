<template>
  <div>
    <h1>{{ info }}</h1>
    <h1>输出学生名字：{{ studentName }}</h1>
    <!-- 
        方式一：通过父组件给子组件传递函数类型的props实现：子给父传递数据
     -->
    <School :getSchoolName="getSchoolName" />
    <!-- 
        方式二：通过父组件给子组件绑定一个自定义事件实现：子给父传递数据（第一种写法，使用@或v-on）
     -->
    <!-- 给组件绑定自定义事件（一次性），简写： -->
    <!-- <Student @ryu.once="getStudentName" /> -->
    <!-- 给组件绑定自定义事件，传统写法： -->
    <!-- <Student v-on:ryu.once="getStudentName" /> -->

    <!-- 
        方式三：通过父组件给子组件绑定一个自定义事件实现：子给父传递数据（第二种写法：使用ref）
     -->
    <Student ref="student" @click.native="clickChild" />
    <!-- ▲▲▲如果需要给子组件上注册DOM原生事件的话，需要加上native修饰符▲▲▲ -->
  </div>
</template>

<script>
import School from "./components/School.vue";
import Student from "./components/Student.vue";
export default {
  name: "App",
  data() {
    return {
      info: "Hello World !",
      studentName: "",
    };
  },
  components: { School, Student },
  methods: {
    getSchoolName(name) {
      console.log("学校名字：" + name);
    },
    getStudentName(name, ...params) {
      console.log("学生名字：" + name, params);
      this.studentName = name;
    },
    demo() {
      console.log("alvin事件被触发了");
    },
    clickChild() {
        alert("子组件Student被点击了")
    },
  },
  mounted() {
    // this.$refs.student.$once("ryu", this.getStudentName); //（一次性）
    // this.$refs.student.$on("ryu", this.getStudentName);
    /**
     * 如果不在methods中事先定义好回调函数，而是直接在给子组件注册事件的时候写回调函数的话
     *  一定一定要写箭头函数，如果写function(...) { ... }的话，里面的this则是指向子组件实例对象
     *  箭头函数的话，本身是没有this的，需要向外找，所以找到了mounted()，那this就肯定是父组件实例对象了
     */
    this.$refs.student.$on("ryu", (name, ...params) => {
      console.log("学生名字：" + name, params);
      this.studentName = name;
    });
    this.$refs.student.$on("alvin", this.demo);
  },
};
</script>

<style>
div {
  background-color: #ddd;
  padding: 10px;
  margin-top: 10px;
  margin-bottom: 10px;
}
</style>
