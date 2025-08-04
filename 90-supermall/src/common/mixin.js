/**
 * 混入是一种代码复用的机制，允许你将组件的选项（如data，methods，生命周期钩子），
 * 提取到一个独立对象中，并在多个组件中复用。
 * 混入可以减少重复代码，提高可维护性。
 */

import { debounce } from "./utils";

// 定义混入图片加载时刷新滚动高度的混入
export const itemImgLoadListenerMixin = {
  data() {
    return {
      refreshScrollHeightMet: null
    }
  },
  mounted() {
    console.log('mixin ---> itemImgLoad');
    // $refs 是在组件 挂载（mounted）之后 才会被填充
    this.refreshScrollHeightMet = () => debounce(this.$refs.scroll.refresh, 200);
    this.$bus.$on('itemImgLoad', this.refreshScrollHeightMet);
  },
}

import BackTop from "@/components/content/backTop/BackTop.vue";
export const backTopMixin = {
  data() {
    return {
      isShowBackTop: false
    }
  },
  components: {
    BackTop
  },
  methods: {
    showBackTop(options) {
      this.isShowBackTop = -options.y > 700 ? true : false; 
    },
    backTop() {
      this.$refs.scroll.backTop(0, 0, 500);
    },
  },
}