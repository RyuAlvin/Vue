export default {
  // context => { state, getters, commit, dispatch, rootState, rootGetters}
  addToCart({state, commit}, payload) {
    const product = state.cartList.find((item) => item.id === payload.id);
    if(product) {
      commit('addCounter', product);
    } else {
      payload.count = 1;
      commit('addProduct', payload);
    }

    console.log(state.cartList);
  }
}