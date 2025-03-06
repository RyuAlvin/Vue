import { ADD_COUNTRY, DELETE_AGE } from "./mutations-types";

export default {
  incre(state) {
    state.vuexCounter++;
  },
  decre(state) {
    state.vuexCounter--;
  },
  increNum(state, num) {
    state.vuexCounter += num;
  },
  decreNum(state, payload) {
    state.vuexCounter -= payload.num;
  },
  [ADD_COUNTRY](state) {
    // 在DevTools中可以看到userInfo中是多了country这个属性，但是页面没有反映，这种添加属性的方式不是响应式
    // state.userInfo.country = 'China';
    // 响应式添加属性
    Vue.set(state.userInfo, 'country', 'China');
  },
  [DELETE_AGE](state) {
    // 在DevTools中可以看到userInfo中是少了age这个属性，但是页面没有反映，这种删除属性的方式不是响应式
    // delete state.userInfo.age;
    // 响应式删除属性
    Vue.delete(state.userInfo, 'age');
  },
  changeMessage(state) {
    setTimeout(() => {
      // 该回调操作能够响应式反映到页面上，但是无法更新调试工具中的state
      state.message = 'Hello Tokyo'
    }, 1000);
  },
  changeMessageInRightWay(state) {
    state.message = 'Hello Tokyo'
  },
  usePromise(state) {
    console.log('mutations ===> ');
    state.message = 'Hello Promise'
  }
}