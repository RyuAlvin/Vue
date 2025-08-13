export default {
  // 增加数量
  addCounter(state, payload) {
    payload.count++;
  },
  // 添加商品
  addProduct(state, payload) {
    state.cartList.push(payload);
  }
}