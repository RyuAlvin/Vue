<template>
  <div class="goods-list">
    <!-- 遍历循环父组件传来的list数据，并传递给GoodsListItem组件 -->
    <goods-list-item v-for="(item, index) in goods" :key="index" :item="item" @click.native="goToDetail(item.iid)"></goods-list-item>
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
  },
  methods: {
    /**
     * 1、添加详情页
     * 2、给详情页添加动态路由
     * 3、给Item添加点击事件，事件内容，通过push跳转至详情页
     *    为什么用push？
     *     标签页之类的互相切换，一般通过用户点击完成，所以只要用replace实现，直接替换路由
     *     而进入详情页之后，需要返回至原来的页面，所以需要在内存中保留原来的页面，因而需要用push实现
     * 4、通过RESTFUL风格传递参数:id，push的时候直接在路径后拼接参数
     *     回忆：如果是通过request param的方式，在push的时候则是通过对象传递
     * @param iid 
     */
    goToDetail(iid) {
      this.$router.push(`detail/${iid}`);
    }
  },
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