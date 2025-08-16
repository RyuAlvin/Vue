<template>
  <div id="cart">
    <nav-bar>
      <div slot="center">购物车({{ length }})</div>
    </nav-bar>
    <scroll class="content" ref="scroll">
      <cart-list />
    </scroll>
  </div>
</template>

<script>
import NavBar from '@/components/common/navBar/NavBar.vue';
import CartList from './childComps/CartList.vue';
import Scroll from '@/components/common/scroll/Scroll.vue';
import { mapGetters } from 'vuex';

export default {
  name: 'Cart',
  components: {
    NavBar,
    Scroll,
    CartList
  },
  computed: {
    // ...mapGetters([
    //   'cartLength',
    //   'cartList'
    // ])
    ...mapGetters({
      length: 'cartLength'
    })
  },
  activated(){
    /**
     * Cart.vue是被<keep-alive>缓存的组件，当Cart组件被激活（即进入Cart组件）的时候，
     * 当前的购物车件数撑开的高度和第一次加载Cart组件的可滚动高度可能存在不匹配的情况。
     * 所以，需要在每次激活的时候取刷新可滚动高度，才能保证正常滚动。
     */
    this.$refs.scroll.refresh();
  }
}
</script>

<style scoped>
#cart {
  height: 100vh;
}
.nav-bar {
  background-color: var(--color-tint);
  color: #fff;
}

.content {
  height: calc(100% - 44px - 49px);
}
</style>