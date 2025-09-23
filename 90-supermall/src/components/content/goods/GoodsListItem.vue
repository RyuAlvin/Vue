<template>
  <div class="goods-item">
    <!-- Vue中自带的load方法，用于监听图片加载完成的操作 -->
    <img v-lazy="showImg" @load="imgLoad"/>
    <div class="goods-info">
      <p>{{ item.title }}</p>
      <span class="price">{{ item.price }}</span>
      <span class="collect">{{ item.cfav }}</span>
    </div>
  </div>
</template>

<script>
export default {
  name: 'GoodsListItem',
  props: {
    item: {
      type: Object,
      default: {}
    }
  },
  methods: {
    /**
     * 1、Home和Detail组件都要做的操作：在图片完全加载时，刷新可滚动高度
     * 2、图片完全加载时，通过事件总线触发itemImgLoad事件
     * 3、由于Home和Detai组件都对itemImgLoad事件进行监听，所以需要防止重复触发。
     *    解决方式一：通过路由区分，触发不同的事件
     *                路由为Home的时候触发homeItemImgLoad事件
     *                路由为Detai的时候触发detailItemImgLoad事件
     *    解决方式二：图片完全加载时触发itemImgLoad事件
     *                Home组件：
     *                  在挂载时，通过事件总线监听itemImgLoad事件，执行回调，防抖动地刷新滚动高度。
     *                  在失活时，手动移除对itemImgLoad事件的监听。
     *                Detail组件：
     *                  在挂载时，和Home组件做的事一样。
     *                  在销毁前，手动移除对itemImgLoad事件的监听。
     * 4、从以上解决方式二可以看出，不管是在Home还是Detail中，
     *    对于itemImgLoad事件的监听以及手动解除，其实操作都是一样的。
     *    为了防止同样写同样的代码，我们需要想办法对其进行抽取和复用。
     *    可以用到Vue中的混入mixin，将相同的代码抽取作为一个混入对象，在Home和Detail中分别混入复用。
     */
    imgLoad() {
      // if(this.$route.path.includes('home')) {
      //   this.$bus.$emit('homeItemImgLoad');
      // } else if(this.$route.path.includes('detail')) {
      //   this.$bus.$emit('detailItemImgLoad');
      // }
      this.$bus.$emit('itemImgLoad');
    }
  },
  computed: {
    /**
     * 用计算属性屏蔽各个组件在使用GoodsList的时候，传入数据的差异
     */
    showImg() {
      return this.item.image || this.item.show.img;
    }
  }
}
</script>

<style>
  .goods-item {
    padding-bottom: 40px;
    position: relative;

    width: 48%;
  }
  .goods-item img {
    width: 100%;
    border-radius: 5px;
  }

  .goods-info {
    font-size: 12px;
    position: absolute;
    bottom: 5px;
    left: 0;
    right: 0;
    overflow: hidden;
    text-align: center;
  }

  .goods-info p {
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    margin-bottom: 3px;
  }

  .goods-info .price {
    color: var(--color-high-text);
    margin-right: 20px;
  }

  .goods-info .collect {
    position: relative;
  }

  /* 通过伪类设置收藏图标 */
  .goods-info .collect::before {
    content: '';
    position: absolute;
    left: -15px;
    top: -1px;
    width: 14px;
    height: 14px;
    background: url("~assets/img/common/collect.svg") 0 0/14px 14px;
  }
</style>