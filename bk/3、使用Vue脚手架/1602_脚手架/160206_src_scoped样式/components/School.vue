<template>
  <div class="demo">
    <h2 class="temp">{{ name }}</h2>
  </div>
</template>

<script>
export default {
  name: "School",
  data() {
    return {
      name: "xxxx大学",
    };
  },
};
</script>

<style lang="less" scoped>
/* 
npm view webpack versions
npm view less-loader versions
npm i less-loader@9
<style scoped>

scoped样式
    作用：让样式在局部生效，防止冲突；
*/
.demo {
  background-color: pink;
  .temp {
    font-size: 30px;
  }
}
</style>
