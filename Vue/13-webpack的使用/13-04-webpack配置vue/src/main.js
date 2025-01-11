import Vue from 'vue'

// 提取App作为组件导入
const App = {
  // 用该template去替换<div id='app'></div>
  template: `
    <div>
      <h1>我是App</h1>
      <p>{{message}}</p>
      <button @click="btnClick">按钮1</button>
    </div>
      `,
  data() {
    return {
      message: '我是APP的内容'
    }
  },
  methods: {
    btnClick() {
      console.log('Hello App');
    }
  }
}

new Vue({
  el: '#app',
  components: {
    App
  }
})