import Vuex from "vuex";
import Vue from "vue";
import { nanoid } from "nanoid";
Vue.use(Vuex);

const actions = {
  increment(context, value) {
    context.commit("INCREMENT", value);
  },
  decrement(context, value) {
    context.commit("DECREMENT", value);
  },
  incrementOdd(context, value) {
    if (state.sum % 2) {
      context.commit("INCREMENT", value);
    }
  },
  incrementWait(context, value) {
    setTimeout(() => {
      context.commit("INCREMENT", value);
    }, 600);
  },
};
const mutations = {
  INCREMENT(state, value) {
    state.sum += value;
  },
  DECREMENT(state, value) {
    state.sum -= value;
  },
};
const state = {
  sum: 1,
  personList: [{ id: nanoid(), name: "张三" }],
};
const getters = {
  bigSum() {
    return state.sum * 10;
  },
};

export default new Vuex.Store({
  actions,
  mutations,
  state,
  getters,
});
