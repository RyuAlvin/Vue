// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  components: { App },
  template: '<App/>'
})

// eslint检查一下代码无法通过
function sum(num1, num2) {
  return num1 + num2;
}

console.log(sum(1, 3));

// 按照以下修改，eslin检查就可以通过。
// 不是所有的eslint标准都适用我们普通的代码规范。
// function sum (num1, num2) {
//   return num1 + num2
// }

// console.log(sum(1, 3))
