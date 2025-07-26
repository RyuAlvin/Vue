<template>
  <div>
    <detail-nav-bar/>
    <detail-swiper :images="topImages"/>
    <detail-base-info :goods="goods"/>
    <detail-shop-info :shop="shop"/>
  </div>
</template>

<script>
import DetailNavBar from './childComps/DetailNavBar.vue';
import DetailSwiper from './childComps/DetailSwiper.vue';
import DetailBaseInfo from './childComps/DetailBaseInfo.vue';
import { getDetailData, Goods, Shop } from '@/network/detail';
import DetailShopInfo from './childComps/DetailShopInfo.vue';

export default {
  name: 'Detail',
  components: { 
    DetailNavBar
    , DetailSwiper 
    , DetailBaseInfo,
    DetailShopInfo
  },
  data() {
    return {
      id: null,
      topImages: [],
      goods: {},
      shop: {}
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
    })
  },
}
</script>

<style>

</style>