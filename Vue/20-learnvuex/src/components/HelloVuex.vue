<template>
  <div id="HelloVuex">
    <h2>HelloVuex ===> {{ counter }}</h2>
  </div>
</template>

<script>
export default {
  name:'HelloVuex',
  props: {
    counter: Number
  }
}
</script>

<style>

</style>