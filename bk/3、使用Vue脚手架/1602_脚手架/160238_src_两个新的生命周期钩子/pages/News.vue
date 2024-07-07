<template>
  <ul>
    <li :style="{ opacity }">Hello World！</li>
    <li>news001 <input type="text" /></li>
    <li>news002 <input type="text" /></li>
    <li>news003 <input type="text" /></li>
  </ul>
</template>

<script>
export default {
  name: "News",
  data() {
    return {
      opacity: 1,
    };
  },
  mounted() {
    // this.timer = setInterval(() => {
    //   console.log("@");
    //   this.opacity -= 0.01;
    //   if (this.opacity <= 0) this.opacity = 1;
    // }, 16);
  },
  beforeDestroy() {
    console.log("Message组件即将被销毁");
  },
  /**
   * 两个新的生命周期钩子
   *  作用：路由组件所独有的两个钩子，用于捕获路由组件的激活状态；
   *  activated：路由组件被激活时触发；
   *  deactivated：路由组件失活时触发；
   */
  activated() {
    this.timer = setInterval(() => {
      console.log("@");
      this.opacity -= 0.01;
      if (this.opacity <= 0) this.opacity = 1;
    }, 16);
  },
  deactivated() {
    clearInterval(this.timer);
  },
};
</script>

<style></style>
