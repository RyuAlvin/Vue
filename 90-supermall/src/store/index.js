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

const store = new Vuex.Store({
  state: {
    cartList: []
  },
  mutations: {
    addToCart(state, payload) {
      const product = state.cartList.find((item) => item.id === payload.id);
      if(product) {
        product.count += 1;
      } else {
        payload.count = 1;
        state.cartList.push(payload);
      }
    }
  }
})

export default store;