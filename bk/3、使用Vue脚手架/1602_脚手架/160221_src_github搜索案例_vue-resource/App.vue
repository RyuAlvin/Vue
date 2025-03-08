<template>
  <div class="container">
    <Search />
    <List />
  </div>
</template>

<script>
/**
 * Module not found: Error: Can't resolve '../fonts/glyphicons-halflings-regular.svg' in '/Users/ryuu/Desktop/マトメ/Vue/Vue/3、使用Vue脚手架/1602_脚手架/src/assets'
 *  通过import引入bootstrap.css会报找不到某种字体的错，
 *  建议将css文件放在public/css/下，然后在index.html中引入
 *      <link rel="bootstrap" href="<%= BASE_URL %>css/bootstrap.css">
 */
// import './assets/bootstrap.css'
import Search from './components/Search.vue'
import List from './components/List.vue'
export default {
  name: "App",
  components: {
    Search,
    List,
  },
};
</script>

<style></style>
