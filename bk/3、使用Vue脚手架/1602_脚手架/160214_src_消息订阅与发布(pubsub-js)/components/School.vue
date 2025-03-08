<template>
  <div id="school">
    <h2>School组件：{{ name }}</h2>
    <h2>从Student组件传递过来的值：{{ receiveVal }}</h2>
  </div>
</template>

<script>
/**
 * 消息订阅与发布（pubsub）
 *  1、一种组件间通信的方式，适用于任意组件间通信；
 *  2、使用步骤：
 *    （1）、安装pubsub：npm i pubsub-js
 *    （2）、引入：import pubsub from 'pubsub-js'
 *    （3）、接收数据：A组件想接收数据，则在A组件中订阅消息，订阅的回调函数留在A组件自身
 *  4、提供数据：pubsub.publish('xxx', 数据)
 *  5、最好在beforeDestroy钩子中，pubsub.unsubscribe(pubId);
 */
import pubsub from "pubsub-js";
export default {
  name: "School",
  data() {
    return {
      name: "xxxx大学",
      receiveVal: "",
    };
  },
  methods: {
    studentToSchool(msgName, value) {
      console.log(msgName);
      this.receiveVal = value;
    },
  },
  mounted() {
    // this.$bus.$on("studentToSchool", this.studentToSchool);
    // this.pubId = pubsub.subscribe("studentToSchool", this.studentToSchool);
    this.pubId = pubsub.subscribe("studentToSchool", (msgName, value) => {
      console.log(msgName);
      this.receiveVal = value;
    });
  },
  beforeDestroy() {
    // this.$bus.$off("studentToSchool");
    pubsub.unsubscribe(pubId);
  },
};
</script>

<style scoped>
#school {
  height: 100px;
  background-color: cornflowerblue;
}
</style>
