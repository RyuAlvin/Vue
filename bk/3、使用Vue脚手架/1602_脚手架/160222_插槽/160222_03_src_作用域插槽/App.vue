<template>
<!-- 
  作用域插槽：
    理解：数据在组件的自身，
          但根据数据生成的结构需要组件的使用者来决定。
          （games数据在Category组件中，但使用数据所遍历出来的结构由APP组件决定）
 -->
  <div class="container">
    <Category title="无序样式">
      <!-- 
        the "scope" attribute for scoped slots 
          have been deprecated and replaced by "slot-scope" since 2.5. 
        The new "slot-scope" attribute can also be used on plain elements 
          in addition to <template> to denote scoped slots.
       -->
      <template slot="scopeSlot" scope="slotObj">
        <ul>
          <li v-for="(item, index) in slotObj.listData" :key="index">
            {{ item }}
          </li>
        </ul>
        <h3 style="color: blue">{{ slotObj.msg }}</h3>
      </template>
    </Category>
    <Category title="有序样式">
      <template slot="scopeSlot" slot-scope="slotObj">
        <ol>
          <li v-for="(item, index) in slotObj.listData" :key="index">
            {{ item }}
          </li>
        </ol>
        <h3 style="color: yellow">{{ slotObj.msg }}</h3>
      </template>
    </Category>
    <Category title="结构赋值1">
      <template slot="scopeSlot" slot-scope="{ listData }">
        <h2 v-for="(item, index) in listData" :key="index">{{ item }}</h2>
      </template>
    </Category>
    <Category title="结构赋值2">
      <template slot="scopeSlot" slot-scope="{ msg }">
        <div style="background-color: goldenrod; width: 100%; height: 50px">
          {{ msg }}
        </div>
      </template>
    </Category>
  </div>
</template>

<script>
import Category from "./components/Category.vue";
export default {
  name: "App",
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
