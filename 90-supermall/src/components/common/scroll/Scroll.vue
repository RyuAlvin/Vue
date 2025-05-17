<template>
  <!-- 
  ref标记DOM元素或者子组件，避免和别的组件中的wrapper类相冲突 
  -->
  <div class="wrapper" ref="wrapper">
    <div class="content">
      <slot></slot>
    </div>
  </div>
</template>

<script>
import BScroll from 'better-scroll';
export default {
  name: 'Scroll',
  data() {
    return {
      scroll: null
    }
  },
  mounted() {
    this.scroll = new BScroll(this.$refs.wrapper, {
      probeType: 3
    });
    this.scroll.scrollTo(0, 0);
  },
  methods: {
    backTop(x, y, time = 300) {
      this.scroll.scrollTo(x, y, time);
    }
  },
}
</script>

<style>
.wrapper {
  overflow: hidden;
}
</style>