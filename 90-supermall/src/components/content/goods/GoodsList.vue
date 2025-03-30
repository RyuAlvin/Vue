<template>
  <div class="goods-list">
    <!-- 遍历循环父组件传来的list数据，并传递给GoodsListItem组件 -->
    <goods-list-item v-for="(item, index) in goods" :key="index" :item="item"></goods-list-item>
  </div>
</template>

<script>
import GoodsListItem from './GoodsListItem.vue';

export default {
  components: { GoodsListItem },
  name: 'GoodsList',
  component: {
    GoodsListItem
  },
  props: {
    goods: {
      type: Array,
      default: []
    }
  }
}
</script>

<style>
.goods-list {
  display: flex;
  /* 用于控制flex容器中的子元素是否换行显示。默认情况下flex容器是不换行（nowrap）， 子元素可能会被压缩或益处*/
  flex-wrap: wrap;
  /* 用于控制flex容器中的子元素在主轴上的分布方式，它会均匀分配flex项目周围的空间，使每个项目两侧的间距相等 */
  justify-content: space-around;

  padding: 2px;
}
</style>