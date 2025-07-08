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
  props: {
    probeType: {
      type: Number,
      default: 3
    },
    pullUpLoad: {
      type: Boolean,
      default: false
    }
  },
  mounted() {
    this.scroll = new BScroll(this.$refs.wrapper, {
      probeType: this.probeType,
      pullUpLoad: this.pullUpLoad // 开启上拉加载
    });

    this.scroll.scrollTo(0, 0);

    this.scroll.on('scroll', options => {
      // console.log('Scroll.vue ===> 'options);
      this.$emit('scroll', options);
    }),

    // 监听上拉加载事件
    this.scroll.on('pullingUp', () => {
      // console.log('上拉加载更多');
      this.$emit('pullingUp');
    })
  },
  methods: {
    backTop(x, y, time = 300) {
      this.scroll.scrollTo(x, y, time);
    },
    finishPullUp() {
      /**
       * 数据记载完成后，必须调用finishPullUp()重置状态。
       * 这是一个必要步骤，类似于一个锁机制，用来控制上拉加载的行为。
       * BetterScroll在触发pullingUp事件后，会立即进入一个"等待完成"状态（类似所著的状态）。
       * 如果不调用finishPullUp()，BetterScroll会认为当前的上拉操作尚未完成，后续的所有上拉操作都会被忽略。
       * 只有调用finishPullUp()后，才会解除锁定，允许下一次上拉再次触发pullingUps事件
       */
      this.scroll.finishPullUp();
    },
    refresh() {
      // 重新计算滚动区域高度（DOM变化后调用，确保滚动正确）
      this.scroll.refresh();

      console.log('Scroll refresh...');
    }
  },
}
</script>

<style>
.wrapper {
  overflow: hidden;
}
</style>