<template>
  <div id="home">
    <nav-bar class="home-nav"><div slot="center">购物街</div></nav-bar>
    <!-- 
    加:（动态绑定），
    特点：
      传递的是JS表达式的结果
      可以传递各种类型的数据（数字、对象、数组、布尔值等）
      可以传递变量、计算属性或方法返回值
    -->
    <scroll class="content" ref="scroll" 
    :probe-type="probeType" 
    :pull-up-load="pullUpLoad"
    @scroll="contentScroll"
    @pullingUp="pullingUp">
      <home-swiper :banners="banners"></home-swiper>
      <home-recommend :recommends="recommends"></home-recommend>
      <feature-view></feature-view>
      <tab-control :titles="['流行', '新款', '精选']" @tab-click="tabClick"></tab-control>
      <!-- 传递当前type下的list数据给GoodsList组件，通过计算属性获取 -->
      <goods-list :goods="showGoods"></goods-list>
    </scroll>
    <!-- 对于自定义组件，click事件无效。需要使用.native修饰符才能调用原生的click事件 -->
    <back-top @click.native="backTop" v-show="isShowBackTop"/>
  </div>
</template>

<script>
import HomeSwiper from './childComps/HomeSwiper.vue';
import HomeRecommend from './childComps/HomeRecommend.vue';
import FeatureView from './childComps/FeatureView.vue';

import NavBar from '@/components/common/navBar/NavBar.vue';
import TabControl from '@/components/content/tabControl/TabControl.vue';
import GoodsList from '@/components/content/goods/GoodsList.vue';
import Scroll from '@/components/common/scroll/Scroll.vue';
import BackTop from '@/components/content/backTop/BackTop.vue';

import { getHomeMultiData, getHomeGoods } from '@/network/home';

export default {
  name: 'Home',
  data() {
    return {
      banners: [],
      recommends: [],
      goods: {
        'pop': { list: [], page: 0},
        'new': { list: [], page: 0},
        'sell': { list: [], page: 0},
      },
      currentType: 'pop',
      probeType: 3,
      pullUpLoad: true,
      isShowBackTop: false
    }
  },
  computed: {
    showGoods(){
      return this.goods[this.currentType].list;
    }
  },
  components: {
    HomeSwiper,
    HomeRecommend,
    FeatureView,
    NavBar,
    TabControl,
    GoodsList,
    Scroll,
    BackTop
  },
  created() {
    /**
     * http://123.207.32.32:7888/api/hy66/home/multidata
     * 获取首页数据
     * 1、安装axios，生产依赖（运行时依赖）
     * 2、封装request.js，看axios官方文档
     * 3、创建network/home.js
     *      引入request.js
     *      关于首页所有的数据请求都封装在home.js
     * 4、在组件创建完成之后，调用异步请求获取数据
     * 5、请求到的数据放在this.data中
     */

     this.getHomeMultiData();

     /**
      * 1、将type和page定义在data中；
      * 2、通过不同type + type下的page作为参数去异步请求数据；
      * 3、若该page数据存在，则去更新data数据type下的page，并push新的数据到list中；
      */
     this.getHomeGoods('sell');
     this.getHomeGoods('pop');
     this.getHomeGoods('new');

     /**
      * 1、Better-Scroll在决定有多少区域可以滚动时，是根据scrollerHeight属性决定
      *    1.1、scrollerHeight属性是根据Better-Scroll的content中的子组件的高度
      *    1.2、但是我们的首页中，刚开始在计算scrollerHeight属性时，是没有将图片计算在内的
      *    1.3、后来图片加载进来之后有了新的高度，但是scrollerHeight属性并没有进行更新，所以滚动出了问题
      * 2、如何解决这个问题？
      *    2.1、监听每一张图片是否加载完成，只要有一张图片加载完成了，执行一次refresh()
      *    2.2、如何监听图片加载完成了？
      *         原生的js监听图片：img.onload = function() { ... }
      *         vue中监听：@load = '方法'
      *    2.3、调用scroll的refresh()
      */
     this.$bus.$on('itemImgLoad', () => {
      this.$refs.scroll.refresh();
      // console.log('----')
     });
  },
  methods: {
    getHomeMultiData() {
      getHomeMultiData().then(res => {
      this.banners = res.data.banner.list;
      this.recommends = res.data.recommend.list;
     })
    },
    getHomeGoods(type) {
      getHomeGoods(type, this.goods[type].page + 1).then(res => {
        if(res.data.list.length > 0) {
          this.goods[type].list.push(...res.data.list)
          this.goods[type].page += 1; 
        }
        // 数据加载完成后，必须调用finishPullUp()重置BetterScroll状态
        this.$refs.scroll.finishPullUp();
      })
    },
    // 子组件TabControl内部触发
    tabClick(index){
      switch(index) {
        case 0:
          this.currentType = 'pop';
          break;
        case 1:
          this.currentType = 'new';
          break;
        case 2:
          this.currentType = 'sell';
          break;
        default:
          break;
      }
    },
    backTop() {
      this.$refs.scroll.backTop(0, 0, 500);
    },
    /**
     * BackTop的显示和隐藏：
     * 1、Home调用Scroll的时候动态传递灵敏度probeType，Scroll通过props接收；
     * 2、Scroll在挂载的时候，绑定scroll事件，并向调用方释放scroll事件以及位置参数；
     * 3、Home中通过v-show动态显示BackTop组件
     * 4、Home接收到scroll事件后，通过位置参数y判断：
     *      大于1000的时候，动态显示BackTop组件、
     *      小于的时候，动态隐藏BackTop组件。
     * @param options 
     */
    contentScroll(options) {
      // console.log('Home.vue ===> ', options);
      this.isShowBackTop = -options.y > 700 ? true : false; 
    },
    /**
     * 1、BetterScroll开启上拉属性
     *    但是属性不要在Scroll.vue组件中写死，需要根据调用方决定。
     *    所以，将上拉属性是否开启作为属性传入Scroll.vue
     * 2、在BetterScroll的mounted生命周期中监听上拉事件
     *    一旦监听到上拉动作则通知调用方，由调用方决定后续操作。
     * 3、在Home.vue中获取到上拉事件被触发的通知，调用后续操作方法。
     *    后续操作1：调用获取数据的方法
     *    后续操作2：重置BetterScroll状态（解除上拉锁）
     *    后续操作3：重新计算滚动区域高度
     */
    pullingUp() {
      // console.log('Home.vue -> 上拉加载更多');
      this.getHomeGoods('pop');
      /**
       * 重新计算滚动区域高度
       * 为什么需要重新计算滚动区域高度？
       *   因为异步请求的数据中包含会影响滚动区域高度的内容（图片等），
       *   所以在保证所有的数据都已请求完成，并反映到DOM上后，需要重新计算，确保滚动最新的滚动区域以适应最新的内容页
       */
      this.$refs.scroll.refresh();
    }
  },
}
</script>

<style scoped>
.home-nav {
  /* 引用base.css中的变量 --color-tint: #ff8198; */
  background-color: var(--color-tint);
  color: #fff;
  font-weight: 700;

  position: fixed;
  z-index: 10;
  top: 0;
  left: 0;
  right: 0;
}

#home {
  padding-top: 44px;
  /* 
  vh 是CSS的相对长度单位，代表当前浏览器视口（viewport）高度的百分比
  100vh 即等于视口总高度的100%
   */
  height: 100vh;
}

.tab-control {
  /* 
  position:sticky
    1、相对于固定的混合：
        元素在容器内时表现为 position: relative
        当视口滚动达到指定阈值时变为 position: fixed
        元素会一直固定在容器内，直到容器滚动离开视口
    2、必须指定阈值：
        必须设置 top、right、bottom 或 left 中的一个
        例如 top: 10px 表示距离视口顶部 10px 时开始固定
   */
  position: sticky;
  top: 44px;
  z-index: 9;
}

.content {
  position: absolute;
  top: 44px;
  bottom: 49px;
  left: 0;
  right: 0;
}
</style>