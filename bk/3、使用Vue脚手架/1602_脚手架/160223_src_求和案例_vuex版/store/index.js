/**
 * Vuex：
 *  在Vue中实现集中式状态（数据）管理的一个Vue插件，
 *  对vue应用中多个组件的共享状态进行集中式的管理（读/写），
 *  也是一种组件间通信的方式，且适用于任意组件间通信。
 */

// 引入Vue核心库
import Vue from "vue";
// 引入Vuex
import Vuex from "vuex";
// 应用Vuex插件
Vue.use(Vuex);

// 准备actions对象--响应组件中用户的动作
const actions = {
  increment(context, value) {
    context.dispatch("demo1", value);
  },
  demo1(context, value) {
    context.dispatch("demo2", value);
  },
  demo2(context, value) {
    context.commit("INCREMENT", value);
  },
  decrement(context, value) {
    context.commit("DECREMENT", value);
  },
  incrementOdd(context, value) {
    context.commit("INCREMENTODD", value);
  },
  incrementWait(context, value) {
    setTimeout(() => {
      context.commit("INCREMENT", value);
    }, 700);
  },
};
// 准备mutations对象--修改state中的数据
const mutations = {
  INCREMENT(state, value) {
    state.sum += value;
  },
  DECREMENT(state, value) {
    state.sum -= value;
  },
  INCREMENTODD(state, value) {
    if (state.sum % 2) {
      state.sum += value;
    }
  },
};
// 准备state对象--保存具体的数据
const state = {
  sum: 0,
};

// 创建并暴露store
export default new Vuex.Store({
  actions,
  mutations,
  state,
});
