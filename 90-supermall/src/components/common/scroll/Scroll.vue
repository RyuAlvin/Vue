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
    })
  },
}
</script>

<style>
.wrapper {
  overflow: hidden;
}
</style>