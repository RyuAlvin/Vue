<template>
  <div class="tab-bar-item">
    <div v-if="!isActive">
      <slot name="item-img"></slot>
    </div>
    <div v-else>
      <slot name="item-img-active"></slot>
    </div>
    <div :class="{active: isActive}">
      <slot name="item-text"></slot>
    </div>
  </div>
</template>

<script>
export default {
  name: 'TarBarItem',
  data() {
    return {
      isActive: false
    }
  },
}
</script>

<style>
.tab-bar-item {
  flex: 1;
  text-align: center;
  height: 49px;
	font-size: 14px;
}

.tab-bar-item img {
	width: 24px;
	height: 24px;
	margin-top: 3px;
	vertical-align: middle;
  margin-bottom: 2px;
}

.active {
  color: hotpink;
}
</style>