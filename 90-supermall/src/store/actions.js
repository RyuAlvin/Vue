import {
  ADD_COUNTER,
  ADD_PRODUCT
} from './mutation-types'

export default {
  // context => { state, getters, commit, dispatch, rootState, rootGetters}
  addToCart({state, commit}, payload) {
    const product = state.cartList.find((item) => item.id === payload.id);
    if(product) {
      commit(ADD_COUNTER, product);
    } else {
      payload.count = 1;
      commit(ADD_PRODUCT, payload);
    }

    // console.log(state.cartList);
  }
}