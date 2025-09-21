import {
  ADD_COUNTER,
  ADD_PRODUCT
} from './mutation-types'

export default {
  // context => { state, getters, commit, dispatch, rootState, rootGetters}
  addToCart({state, commit}, payload) {
    return new Promise((resolve, reject) => {
      const product = state.cartList.find((item) => item.id === payload.id);
      if(product) {
        commit(ADD_COUNTER, product);
        resolve('商品数量 + 1 ~~~');
      } else {
        payload.count = 1;
        commit(ADD_PRODUCT, payload);
        resolve('新商品 + 1 ~~~')
      }
      // console.log(state.cartList);
    })
  }
}