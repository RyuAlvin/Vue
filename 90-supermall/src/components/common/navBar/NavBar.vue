<!-- 
 1、导航<div>不要用id，用class，因为每个tab都需要用到nav，用id的话会冲突
      行高44px，内容居中
 2、导航组件分三部分：左，中，右（按需显示，不同tab需要不同的nav）
 3、通3个具名插槽分配左，中，右部分
 4、每个插槽被<div>嵌套，添加类样式
  -->
<template>
  <div class="nav-bar">
    <div class="nav-left">
      <slot name="left"></slot>
    </div>
    <div class="nav-center">
      <slot name="center"></slot>
    </div>
    <div class="nav-right">
      <slot name="right"></slot>
    </div>
  </div>
</template>

<script>
export default {
  name: 'NavBar'
}
</script>

<style>
.nav-bar {
  height: 44px;
  line-height: 44px;
  text-align: center;
  display: flex;
  box-shadow: 0 1px 1px rgba(100, 100, 100, .1);
}

.nav-center {
  flex: 1;
}

.nav-left, .nav-right {
  width: 60px;
}
</style>