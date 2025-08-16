<template>
  <h2>{{ product }}</h2>
</template>

<script>
export default {
  name: 'CartListItem',
  props: {
    product: {
      type: Object,
      default: []
    }
  }
}
</script>

<style>

</style>