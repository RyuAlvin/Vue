<template>
  <div>
    <detail-nav-bar/>
    <detail-swiper :images="topImages"/>
  </div>
</template>

<script>
import DetailNavBar from './childComps/DetailNavBar.vue';
import DetailSwiper from './childComps/DetailSwiper.vue';
import { getDetailData } from '@/network/detail';
export default {
  name: 'Detail',
  components: { DetailNavBar, DetailSwiper },
  data() {
    return {
      id: null,
      topImages: []
    }
  },
  created() {
    // 保存主页传过来的详情页id
    this.id = this.$route.params.id;

    // 获取详情页数据
    getDetailData(this.id).then(res => {
      this.topImages = res.result.itemInfo.topImages;
    })
  },
}
</script>

<style>

</style>