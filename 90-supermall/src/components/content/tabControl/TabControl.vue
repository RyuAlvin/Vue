<template>
  <div class="tab-control">
    <div class="tab-control-item" v-for="(item, index) in titles" 
    :key="index" 
    :class="{ active: currentIndex === index }" 
    @click="tabClick(index)">
      <span>{{ item }}</span>
    </div>
  </div>
</template>

<script>
/**
 * 1、各个菜单页面都会用到的组件，因此属于共通组件。
 * 2、该组件并不是像顶部，底部那种在各个不同项目中通用的组件，具有项目特殊性，因此划分到components/content下，即业务共通组件。
 * 3、布局 div>div>span
 * 4、不同的菜单展示的title不同，因此title由父组件传入，循环展示。
 * 5、绑定动态类和点击事件，若当前被点击的index等于该title的index，则该动态类有效
 */
export default {
  name: 'TabControl',
  data() {
    return {
      currentIndex: 0
    }
  },
  props: {
    titles: {
      type: Array,
      default() {
        return [];
      }
    }
  },
  methods: {
    tabClick(index){
      this.currentIndex = index;
      // 将当前选中的标签索引传递给父组件
      this.$emit('tab-click', index);
    }
  },
}
</script>

<style>
.tab-control {
  display: flex;
  height: 44px;
  line-height: 44px;
  text-align: center;
  font-size: 15px;
  background-color: #fff;
}

.tab-control-item {
  flex: 1;
}

.tab-control-item span {
  padding: 5px;
}

.active {
  color: var(--color-high-text);
}

.active span {
  border-bottom: 2px solid var(--color-high-text);
}
</style>