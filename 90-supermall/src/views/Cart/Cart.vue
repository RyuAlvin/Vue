<template>
  <div>
    <nav-bar>
      <div slot="center">购物车</div>
    </nav-bar>
  </div>
</template>

<script>
import NavBar from '@/components/common/navBar/NavBar.vue';

export default {
  name: 'Cart',
  components: {
    NavBar
  }
}
</script>

<style scoped>
.nav-bar {
  background-color: var(--color-tint);
  color: #fff;
}
</style>