<template>
  <div class="container">
    <!-- <Category :title="美食" :list="foods" />
    <Category :title="游戏" :list="games" />
    <Category :title="电影" :list="films" /> -->
    <Category title="美食">
      <img
        slot="center"
        src="https://s3.ax1x.com/2021/01/16/srJlq0.jpg"
        alt="大金链子小手表，一天三顿吃烧烤"
      />
      <a href="" slot="footer">美食热线</a>
    </Category>
    <Category title="游戏">
      <ul slot="center">
        <li v-for="(item, index) in this.games" :key="index">{{ item }}</li>
      </ul>
      <a href="" slot="footer">618活动</a>
      <a href="" slot="footer">暑期活动</a>
    </Category>
    <Category title="电影">
      <video
        slot="center"
        controls
        src="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"
      ></video>
      <!-- 
        具名插槽：v-slot:footer 这种写法，只适用于组件和<template></template>
       -->
      <!-- <div v-slot="footer"> -->
      <div slot="footer">
        <div class="foot">
          <a href="">阿凡达</a>
          <a href="">勇敢的心</a>
        </div>
        <h4 class="foot">欢迎来到影院</h4>
      </div>
    </Category>
    <Category title="其他">
      <h1 slot="center">啥也没有</h1>
      <template v-slot:footer>
        <!-- <template slot="footer"> -->
        <div class="foot">
          <a href="">阿凡达</a>
          <a href="">勇敢的心</a>
        </div>
        <h4 class="foot">欢迎来到影院</h4>
      </template>
    </Category>
  </div>
</template>

<script>
import Category from "./components/Category.vue";
export default {
  name: "App",
  data() {
    return {
      foods: ["火锅", "烧烤", "小龙虾", "牛排"],
      games: ["红色警戒", "穿越火线", "劲舞团", "超级玛丽"],
      films: ["《教父》", "《拆弹专家》", "《你好，李焕英》", "《尚硅谷》"],
    };
  },
  components: {
    Category,
  },
};
</script>

<style scoped>
.container {
  display: flex;
  justify-content: space-around;
}

.foot {
  display: flex;
  justify-content: space-around;
}

/* 
对于img、video的样式，可以放在App中也可以放在Category中。
    如果放在Category中的话，
    也就是在App中完成对Category的解析时是不带样式的，渲染呈现的时候才带上样式。
*/
img {
  width: 100%;
}

video {
  width: 100%;
}
</style>
