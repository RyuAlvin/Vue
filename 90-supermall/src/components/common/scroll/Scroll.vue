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
      /**
       * 用于控制滚动事件的监听频率和精度。
       * 它决定了在滚动过程中，BetterScroll如何触发scroll事件，适用于需要实时获取滚动位置。
       */
      probeType: this.probeType,
      pullUpLoad: this.pullUpLoad // 开启上拉加载
    });

    this.scroll.scrollTo(0, 0);

    /**
     * 0：不派发scroll事件
     *    性能最优，无需监听滚动位置时使用
     * 1：非实时派发scroll事件（仅在滚动动画结束后触发一次）
     *    适用于只需要知道滚动结束位置的场景
     * 2：实时派发scroll事件（在手指滚动的过程中触发，惯性滚动时不触发）
     *    适合许哟啊实时反馈但不需要高精度的场景
     * 3：实时派发scroll事件（只要是滚动触发，包括手指拖动和惯性滚动）
     *    需要高精度实时滚动位置的场景（如联动效果）
     * 
     * 只有开启实施派发scroll事件（2和3），才做监听
     */
    if(this.scroll.probeType === 2 || this.scroll.probeType === 3 ) {
      this.scroll.on('scroll', options => {
        // console.log('Scroll.vue ===> 'options);
        this.$emit('scroll', options);
      })
    }

    // 开启上拉加载的时候，才监听上拉加载事件
    if(this.scroll.pullUpLoad) {
      // 监听上拉加载事件
      this.scroll.on('pullingUp', () => {
        // console.log('上拉加载更多');
        this.$emit('pullingUp');
      })
    }
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