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
  sum: 1,
  nation: "中国",
  city: "厦门",
};

// 当state中的数据需要经过加工后再使用时，可以使用getters加工
const getters = {
  bigSum(state) {
    return state.sum * 10;
  },
};

// 创建并暴露store
export default new Vuex.Store({
  actions,
  mutations,
  state,
  getters,
});
