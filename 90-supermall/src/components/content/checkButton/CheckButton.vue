<template>
  <div class="check-button" :class="{check: isChecked}">
    <div>
      <img src="~assets/img/cart/tick.svg"/>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    isChecked: {
      type: Boolean,
      default: false
    }
  }
}
</script>

<style scoped>
.check-button {
  background-color: #fff;
  border-radius: 50%;
  border: 2px solid #aaa;
  padding: 1.5px;
}

.check {
  border-color: red;
  background-color: red;
}
</style>