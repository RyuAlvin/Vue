<template>
  <nav-bar>
    /**
     * 1、详情页导航栏分为三个部分：
     *    返回按钮，导航内容
     * 2、详情页导航栏属于详情页的子组件
     *    在详情页中建子文件夹，对导航栏共通组件包一层作为详情页专用的导航栏组件
     * 3、导航内容部分（center插槽）
     *    3.1、定义一个数组存放导航文字内容
     *    3.2、外层display:flex布局，内层flex:1让其均等分间隔
     *    3.3、添加点击事件，保存当前点击的currentIndex
     *    3.4、currentIndex=index的时候，激活点击类
     * 4、返回按钮（left插槽）
     *    4.1、引用图片
     *    4.2、添加点击事件，通过go(-1)或者back返回至迁移前页面
     */
    <div slot="left" class="back-nav" @click="back">
      <img src="~assets/img/common/back.svg"/>
    </div>
    <div slot="center" class="detail-nav">
      <div 
      v-for="(item, index) in navContent" 
      :key="index" 
      class="detail-nav-item" 
      :class="{active: currentIndex == index}" @click="navClick(index)">
        {{ item }}
      </div>
    </div>
  </nav-bar>
</template>

<script>
import NavBar from '@/components/common/navBar/NavBar.vue';
export default {
  data() {
    return {
      navContent: ['商品', '参数', '评论', '推荐'],
      currentIndex: 0
    }
  },
  components: {
    NavBar
  },
  methods: {
    navClick(index) {
      this.currentIndex = index;
    },
    back() {
      // this.$router.go(-1);
      this.$router.back();
    }
  },
}
</script>

<style>
.detail-nav {
  display: flex;
}

.detail-nav-item {
  flex: 1;
}

.active {
  color: var(--color-high-text);
}

.back-nav {
  margin-top: 6px;
}
</style>