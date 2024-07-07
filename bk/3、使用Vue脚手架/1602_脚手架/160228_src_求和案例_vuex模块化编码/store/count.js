export default {
  namespaced: true,
  state: {
    sum: 1,
    nation: "中国",
    city: "北京",
  },
  getters: {
    bigSum(state) {
      return state.sum * 10;
    },
  },
  actions: {
    increment(context, value) {
      context.commit("INCREMENT", value);
    },
    decrement(context, value) {
      context.commit("DECREMENT", value);
    },
    incrementOdd(context, value) {
      if (context.state.sum % 2) {
        context.commit("INCREMENT", value);
      }
    },
    incrementWait(context, value) {
      setTimeout(() => {
        context.commit("INCREMENT", value);
      }, 600);
    },
  },
  mutations: {
    INCREMENT(state, value) {
      state.sum += value;
    },
    DECREMENT(state, value) {
      state.sum -= value;
    },
  },
};
