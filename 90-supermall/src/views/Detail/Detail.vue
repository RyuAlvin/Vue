<template>
  <div id="detail">
    <detail-nav-bar ref="nav" @nav-click="navClick"/>
    <scroll class="content"
    ref="scroll"
    :probe-type="probeType" 
    :pull-up-load="pullUpLoad"
    @pullingUp="pullingUp"
    @scroll="contentScroll">
      <detail-swiper :images="topImages"/>
      <detail-base-info :goods="goods"/>
      <detail-shop-info :shop="shop"/>
      <detail-goods-info :detail-info="detailInfo" @img-load="imgLoad"/>
      <detail-param-info ref="param" :param-info="paramInfo"/>
      <detail-comment-info ref="comment" :comment-info="commentInfo"/>
      <detail-recommend-info ref="recommend" :recommend-list="recommendList"/>
    </scroll>
    <detail-bottom-bar/>
    <!-- 对于自定义组件，click事件无效。需要使用.native修饰符才能调用原生的click事件 -->
    <back-top @click.native="backTop" v-show="isShowBackTop"/>
  </div>
</template>

<script>
import DetailNavBar from './childComps/DetailNavBar.vue';
import Scroll from '@/components/common/scroll/Scroll.vue';
import DetailSwiper from './childComps/DetailSwiper.vue';
import DetailBaseInfo from './childComps/DetailBaseInfo.vue';
import DetailShopInfo from './childComps/DetailShopInfo.vue';
import DetailGoodsInfo from './childComps/DetailGoodsInfo.vue';
import DetailParamInfo from './childComps/DetailParamInfo.vue';
import DetailCommentInfo from './childComps/DetailCommentInfo.vue';
import DetailRecommendInfo from './childComps/DetailRecommendInfo.vue';
import DetailBottomBar from './childComps/DetailBottomBar.vue';

import { getDetailData, getRecommend, Goods, Shop, GoodsParam } from '@/network/detail';

// 导入混入
import { itemImgLoadListenerMixin, backTopMixin } from '@/common/mixin';
import { debounce } from '@/common/utils';

export default {
  name: 'Detail',
  components: {
    DetailNavBar,
    Scroll,
    DetailSwiper,
    DetailBaseInfo,
    DetailShopInfo,
    DetailGoodsInfo,
    DetailParamInfo,
    DetailCommentInfo,
    DetailRecommendInfo,
    DetailBottomBar
  },
  // 引入混入
  mixins: [ itemImgLoadListenerMixin, backTopMixin ],
  data() {
    return {
      id: null,
      probeType: 3,
      pullUpLoad: true,
      topImages: [],
      goods: {},
      shop: {},
      detailInfo: {},
      paramInfo: {},
      commentInfo: {},
      recommendList: [],
      navTitleYs: [],
      refreshOffsetTopMet: null,
      currentIndex: 0
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
      // 保存参数信息
      this.paramInfo = new GoodsParam(data.itemParams.info, data.itemParams.rule);
      // 2.7.保存评论信息
      if (data.rate.list) {
        this.commentInfo = data.rate.list[0];
      }
    });
    
    getRecommend().then(res => {
      this.recommendList = res.data.list;
    })

    // 创建刷新offsetTop的防抖函数
    this.refreshOffsetTopMet = debounce(() => {
      // 首先清空保存offsetTop的数组变量
      this.navTitleYs = [];
      // 商品标题对应的offsetTop
      this.navTitleYs.push(0);
      // 参数标题对应的offsetTop
      this.navTitleYs.push(this.$refs.param.$el.offsetTop);
      // 评论标题对应的offsetTop
      this.navTitleYs.push(this.$refs.comment.$el.offsetTop);
      // 推荐标题对应的offsetTop
      this.navTitleYs.push(this.$refs.recommend.$el.offsetTop);
      // 在末尾存储一个最大数值，简化判断条件
      this.navTitleYs.push(Number.MAX_VALUE);
    }, 200)
  },
  beforeDestroy() {
    // 组件销毁前，解除对图片加载完成事件的监听
    this.$bus.$off('itemImgLoad', this.refreshScrollHeightMet);
  },
  methods: {
    imgLoad() {
      // 防抖式地刷新滚动高度
      this.refreshScrollHeightMet();
      /**
       * 点击标题滚动到对应内容总结
       * 【实现要点】
       * 1、在数据加载完成后记录对应内容块的offsetTop
       * 2、点击标题时获取对应索引
       * 3、通过索引获取对应内容块的offsetTop
       * 
       * 【实现步骤】
       * 1、获取标题对应内容块的offsetTop
       *    a、不能在created中获取对应内容块的offsetTop
       *       因为在created中只能获取到数据，组件还未渲染，
       *       无法获取元素，更无法获取到到offsetTop。
       *    b、可通过this.$nextTick()解决上述问题
       *       this.$nextTick(() => console.log(this.$refs.tab.$el.offsetTop))
       *       nextTick主要用于处理DOM更新后的操作
       *       但是，商品数据还未加载完成的时候，该时间点获取到的并不是最终的offsetTop
       *    c、可在updated中获取对应内容块的offsetTop
       *       updated的数据时最新的，页面也是最新的，即页面和数据保持同步
       *       但是，每一次数据变化，重新渲染的时机，都会取重新获取offsetTop，更新太频繁
       *    d、mounted中也不行，还未获取到数据（因为获取数据时异步的），更不存在完全渲染
       *    e、最优解是在图片加载完成后，延迟获取高度（通过抖动函数）
       * 2、将获取到对应内容块的offsetTop保存到data中（类型为数组）
       * 3、在导航栏组件中，点击不同标题触发事件，并传递标题的索引
       * 4、Detail组件中，接收标题点击事件，根据索引去data中获取offsetTop，
       *    通过scroll中的scrollTo方法滚动至对应内容块（设置滚动延迟时间）
       */
      // 防抖式地刷新各个标题的offsetTop
      this.refreshOffsetTopMet();
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
    navClick(index) {
      this.$refs.scroll.scrollTo(0, -this.navTitleYs[index], 500); 
    },
    contentScroll(position) {
      /**
       * 滚动内容显示对应标题
       * 3 <= i
       * 2 <= i < 3
       * 1 <= i < 2
       * 0 <= i < 1
       */
      const length = this.navTitleYs.length;
      const positionY = -position.y;
      // let idx;
      // for(let i in this.navTitleYs) {
      //   idx = parseInt(i);
      //   if((this.currentIndex !== idx) && (
      //     ((idx === length - 1) && (positionY >= this.navTitleYs[idx])) || (
      //         (idx < length - 1) && (this.navTitleYs[idx] <= positionY && positionY < this.navTitleYs[idx + 1])))) {
      //       this.currentIndex = idx;
      //       console.log(this.currentIndex);
      //       this.$refs.nav.currentIndex = this.currentIndex;
      //   }
      // }
      // 末尾的最大数值不参与循环，只用于简化判断
      for (let i = 0; i < length - 1; i++) {
        if((this.currentIndex !== i) 
          && (this.navTitleYs[i] <= positionY && positionY < this.navTitleYs[i + 1])) {
            this.currentIndex = i;
            console.log(this.currentIndex);
            this.$refs.nav.currentIndex = this.currentIndex;
        }
      }

      // 是否显示回到顶部
      this.showBackTop(position);
    }
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
  height: calc(100% - 44px - 49px);
}
</style>