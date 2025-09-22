import SelfToast from "./SelfToast.vue";

const obj = { }

obj.install = function(Vue) {
  // console.log('SelfToast => install ...');
  // console.log('arg0 => ', Vue); // Vue对象
  // console.log('arg1 => ', b); // undefined

  // 1、创建Vue组件的构造函数（即Vue子类）
  const SelfToastConstructor = Vue.extend(SelfToast);
  // 2、通过Vue组件的构造函数创建Vue组件实例
  const selfToastInstance = new SelfToastConstructor();
  // 3、将Vue组件实例挂载到指定元素上（创建一个div让该Vue组件挂载）
  selfToastInstance.$mount(document.createElement('div'));
  // 4、至此，Vue组件实例以及虚拟DOM模板都具备了，再将Vue组件实例（虚拟DOM元素）放到document上
  document.body.appendChild(selfToastInstance.$el);
  // 5、将该Vue组件实例全局注册到Vue原型上
  Vue.prototype.$toast = selfToastInstance;
}

export default obj;