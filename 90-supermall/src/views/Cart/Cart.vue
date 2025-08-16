<template>
  <div id="cart">
    <nav-bar>
      <div slot="center">购物车({{ length }})</div>
    </nav-bar>
    <scroll class="content">
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