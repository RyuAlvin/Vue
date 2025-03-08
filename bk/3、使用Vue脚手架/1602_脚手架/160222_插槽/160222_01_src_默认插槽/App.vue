<template>
  <div class="container">
    <!-- <Category :title="美食" :list="foods" />
    <Category :title="游戏" :list="games" />
    <Category :title="电影" :list="films" /> -->
    <Category title="美食">
      <img
        src="https://s3.ax1x.com/2021/01/16/srJlq0.jpg"
        alt="大金链子小手表，一天三顿吃烧烤"
      />
    </Category>
    <Category title="游戏">
      <ul>
        <li v-for="(item, index) in this.games" :key="index">{{ item }}</li>
      </ul>
    </Category>
    <Category title="电影">
      <video
        controls
        src="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"
      ></video>
    </Category>
    <Category title="啥也没有"></Category>
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

<style>
.container {
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
