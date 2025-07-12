<template>
    <swiper>
    <swiper-item v-for="(item, index) in banners" :key="index">
      <a :href="item.link">
        <img :src="item.image923" @load="imgLoad"/>
      </a>
    </swiper-item>
  </swiper>
</template>

<script>
import { Swiper, SwiperItem } from '@/components/common/swiper';
export default {
  name: 'HomeSwiper',
  data() {
    return {
      isLoad: false
    }
  },
  components: {
    Swiper,
    SwiperItem
  },
  props: {
    banners: {
      type: Array,
      default: []
    }
  },
  methods: {
    imgLoad() {
      if(!this.isLoad) {
        this.$emit('img-load');
        this.isLoad = true;
      }
    }
  },
}
</script>

<style>

</style>