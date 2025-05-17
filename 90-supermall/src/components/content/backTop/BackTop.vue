/**
BackTop组件封装:
1、BackTop组件位置：
    业务组件 components/content
2、BackTop组件元素结构：
    div包裹img，img指定src
3、BackTop组件样式：
    整个div指定class
    对img指定长宽
    对class指定fix定位
4、BackTop组件点击事件：
    对于自定义组件，click事件无效。需要使用.native修饰符才能调用原生的click事件
    点击的时候调用scroll的scroll方法
5、Scroll组件：
    初始挂载的时候，滚动至顶部位置
    封装一个滚动至顶部位置的方法
 */
<template>
  <div class="back-top">
    <img src="~assets/img/common/top.png"/>
  </div>
</template>

<script>
export default {

}
</script>

<style>
.back-top {
  position: fixed;
  right: 20px;
  bottom: 60px;
}

.back-top img {
  width: 45px;
  height: 45px;
}
</style>