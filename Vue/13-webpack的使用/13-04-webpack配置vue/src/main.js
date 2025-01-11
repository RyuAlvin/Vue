import Vue from 'vue'

const app = new Vue({
  el: '#app',
  // 用该template去替换<div id='app'></div>
  template: `
<div>
  <h1>我是APP</h1>
  <p>{{message}}</p>
</div>
  `,
  data: {
    message: '我是APP的内容'
  }
})