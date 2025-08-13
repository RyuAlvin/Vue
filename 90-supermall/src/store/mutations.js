import {
  ADD_COUNTER,
  ADD_PRODUCT
} from './mutation-types'

export default {
  // 增加数量
  [ADD_COUNTER](state, payload) {
    payload.count++;
  },
  // 添加商品
  [ADD_PRODUCT](state, payload) {
    state.cartList.push(payload);
  }
}