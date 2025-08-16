<template>
  <div>
    <nav-bar>
      <div slot="center">购物车({{ length }})</div>
    </nav-bar>
  </div>
</template>

<script>
import NavBar from '@/components/common/navBar/NavBar.vue';
import { mapGetters } from 'vuex';

export default {
  name: 'Cart',
  components: {
    NavBar
  },
  computed: {
    // ...mapGetters([
    //   'cartLength',
    //   'cartList'
    // ])
    ...mapGetters({
      length: 'cartLength',
      list: 'cartList'
    })
  }
}
</script>

<style scoped>
.nav-bar {
  background-color: var(--color-tint);
  color: #fff;
}
</style>