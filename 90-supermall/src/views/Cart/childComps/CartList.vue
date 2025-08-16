<template>
  <div>
    <cart-list-item v-for="(item, index) in list" :key="index" :product="item"/>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import CartListItem from './CartListItem.vue';

export default {
  name: 'CartList',
  components: {
    CartListItem
  },
  computed: {
    ...mapGetters({
      list: 'cartList'
    })
  }
}
</script>

<style>

</style>