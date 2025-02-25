<template>
  <div id="tab-bar">
    <div class="tab-bar-item">
      <img src="../../assets/img/tabbar/home.png" alt=""/>
      <div>首页</div>
    </div>
    <div class="tab-bar-item">
      <img src="../../assets/img/tabbar/category.png" alt=""/>
      <div>分类</div>
    </div>
    <div class="tab-bar-item">
      <img src="../../assets/img/tabbar/cart.png" alt=""/>
      <div>购物车</div>
    </div>
    <div class="tab-bar-item">
      <img src="../../assets/img/tabbar/profile.png" alt=""/>
      <div>购物车</div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'TabBar'
}
</script>

<style>
#tab-bar {
  display: flex;
  background-color: #f6f6f6;

  position: fixed;
  left: 0;
  right: 0;
  bottom: 0;

  box-shadow: 0 -1px 1px rgba(100, 100, 100, .1);
}

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
</style>