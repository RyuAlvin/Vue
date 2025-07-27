<template>
  <div id="detail">
    <detail-nav-bar/>
    <scroll class="content"
    ref="scroll"
    :probe-type="probeType" 
    :pull-up-load="pullUpLoad"
    @pullingUp="pullingUp">
      <detail-swiper :images="topImages"/>
      <detail-base-info :goods="goods"/>
      <detail-shop-info :shop="shop"/>
      <detail-goods-info :detail-info="detailInfo" @imgLoad="imgLoad"/>
    </scroll>
  </div>
</template>

<script>
import DetailNavBar from './childComps/DetailNavBar.vue';
import Scroll from '@/components/common/scroll/Scroll.vue';
import DetailSwiper from './childComps/DetailSwiper.vue';
import DetailBaseInfo from './childComps/DetailBaseInfo.vue';
import DetailShopInfo from './childComps/DetailShopInfo.vue';
import DetailGoodsInfo from './childComps/DetailGoodsInfo.vue';

import { getDetailData, Goods, Shop } from '@/network/detail';

export default {
  name: 'Detail',
  components: { 
    DetailNavBar,
    DetailSwiper,
    DetailBaseInfo,
    DetailShopInfo,
    DetailGoodsInfo,
    Scroll
  },
  data() {
    return {
      id: null,
      probeType: 3,
      pullUpLoad: true,
      topImages: [],
      goods: {},
      shop: {},
      detailInfo: {}
    }
  },
  created() {
    // 保存主页传过来的详情页id
    this.id = this.$route.params.id;

    // 获取详情页数据
    getDetailData(this.id).then(res => {
      // 获取结果
      const data = res.result;
      // 获取顶部信息
      this.topImages = data.itemInfo.topImages;
      // 获取商品基本信息
      this.goods = new Goods(data.itemInfo, data.columns, data.shopInfo.services);
      // 获取店铺信息
      this.shop = new Shop(data.shopInfo);
      // 获取商品信息
      this.detailInfo = data.detailInfo;
    })
  },
  methods: {
    imgLoad() {
      this.$refs.scroll.refresh();
    },
    pullingUp() {
      /**
       * 重新计算滚动区域高度
       * 为什么需要重新计算滚动区域高度？
       *   因为异步请求的数据中包含会影响滚动区域高度的内容（图片等），
       *   所以在保证所有的数据都已请求完成，并反映到DOM上后，需要重新计算，确保滚动最新的滚动区域以适应最新的内容页
       */
      this.$refs.scroll.refresh();
    },
  },
}
</script>

<!-- 
详情页加入滚动效果
1、从首页迁移至详情页，底部导航栏就不需要显示了
   底部导航栏属于固定定位，需要让详情页盖过底部导航栏
   因此，需要让详情页相对于当前位置往上浮动，通过position: relative相对于当前位置往上浮动z-index: 1
   往上浮动后，由于详情页背景透明，底部导航栏内容依然可见，所需通过设置背景覆盖底部导航栏内容
2、引入scroll组件，将详情页内容全部放在scroll中
3、可滚动部分需要设置高度，具体高度为：可视窗口高度 - 顶部导航栏（44px），通过计算属性获取
 -->
<style scoped>
#detail {
  position: relative;
  z-index: 1;
  background: #fff;
  /* 1vh 等于视口（浏览器可视区域）高度的 1%，100vh 等于视口的完整高度 */
  height: 100vh;
}

.content {
  height: calc(100% - 44px);
}
</style>