import Vue from 'vue'
import App from './App'

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  // components: { App },
  // template: '<App/>'
  render: (h) => {
    return h(App);
  }
})

/**
 * AST：Abstract Syntax Tree，抽象语法树
 * VM：Virtual DOM，虚拟DOM
 * 
 * Tempalte => AST => Render => VM => UI
 *  编译阶段（Tempalte => AST => Render）：通过"vue-template-compiler"将模板解析和编译，生成渲染函数。
 *  运行阶段（Render => VM => UI）：执行渲染函数，生成虚拟DOM，通过Diff和Patch更新真实DOM。
 * 
Template 即：template：'<App/>'中的模板，用于定义组件的结构和内容。
  模板本身是静态的，需要经过Vue的编译器解析为代码。
  <template>
    <div id="app">
      <h1>{{ title }}</h1>
      <p>{{ message }}</p>
    </div>
  </template>
  
AST 即：Vue编译器将模板解析为抽象语法树，将<template>模板解析成对象节点树。
  {
    type: 'element',
    tag: 'div',
    attrs: { id: 'app' },
    children: [
      {
        type: 'element',
        tag: 'h1',
        children: [
          { type: 'expression', content: 'title' }
        ]
      },
      {
        type: 'element',
        tag: 'p',
        children: [
          { type: 'expression', content: 'message' }
        ]
      }
    ]
  }

Render 即：Vue将AST转换成渲染函数，它是JS代码，用于动态创建虚拟DOM。
  h 即 createElement函数，在运行时被调用，以生成实际的虚拟DOM。
  function render() {
    return h('div', { id: 'app' }, [
      h('h1', null, [this.title]),
      h('p', null, [this.message])
    ]);
  }

VM 即：虚拟DOM，通过运行时执行渲染函数生成DOM树，这是UI的轻量级表示。
  虚拟DOM是一个JS对象，描述了真实DOM的结构和状态。
  虚拟DOM在内存中操作，不直接作用域真实DOM。
  它在每次数据变化时都会被重新生成，用于比较新旧虚拟DOM。
  {
    type: 'div',
    props: { id: 'app' },
    children: [
      { type: 'h1', props: null, children: ['Hello Vue'] },
      { type: 'p', props: null, children: ['This is a message'] }
    ]
  }
  
UI 即：真实DOM更新。
  通过Diff算法比较新旧虚拟DOM，生成最小的更新路径并应用到真实DOM。
  步骤：
    1、Diff算法：
        1.1、对比新旧虚拟DOM，找出差异（节点增加、删除、属性变化等）。
        1.2、差异计算是高效的，避免了全量更新。
    2、Patch操作：
        2.1、将差异应用到真实DOM中，更新页面显示。
 */