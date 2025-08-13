/**
 * Vuex处理添加到购物车操作
 * 1、引入Vue、Vuex
 * 2、Vue使用Vuex
 * 3、在state中创建存放产品的购物车共享数据
 * 4、在mutations中创建添加至购物车的操作处理
 *    4.1、通过产品id判断购物车中该产品是否存在
 *    4.2、存在则将数量+1
 *    4.3、不存在则将数量设置为1，并添加至购物车
 */
import Vue from "vue";
import Vuex from "vuex"

Vue.use(Vuex);

/**
 * Vuex中代码的重构：
 * 1、mutations中的每一个方法遵循单一职能原则
 * 2、将mutations中的判断操作放到actions中，即：
 *    a、mutations中定义两个操作：
 *       添加数量和添加商品
 *    b、actions中定义判断操作：
 *       购物车中存在该商品，则调用mutations中的添加数量操作
 *       购物车中不存在该商品，则调用mutaions中的添加商品操作
 * 3、各组件中通过dispatch调用actions（不直接调用mutations）
 */
const store = new Vuex.Store({
  state: {
    cartList: []
  },
  mutations: {
    // 增加数量
    addCounter(state, payload) {
      payload.count++;
    },
    // 添加商品
    addProduct(state, payload) {
      state.cartList.push(payload);
    }
  },
  actions: {
    // context => { state, getters, commit, dispatch, rootState, rootGetters}
    addToCart({state, commit}, payload) {
      const product = state.cartList.find((item) => item.id === payload.id);
      if(product) {
        commit('addCounter', product);
      } else {
        payload.count = 1;
        commit('addProduct', payload);
      }
    }
  }
})

export default store;