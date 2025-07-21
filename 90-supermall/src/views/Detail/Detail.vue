<template>
  <div>
    详情页
    {{ this.id }}
  </div>
</template>

<script>
export default {
  data() {
    return {
      id: null
    }
  },
  created() {
    this.id = this.$route.params.id;
  },
}
</script>

<style>

</style>