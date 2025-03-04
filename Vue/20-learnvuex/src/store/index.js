import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  state:{
    vuexCounter: 0
  },
  mutations: {
    incre(state) {
      state.vuexCounter++;
    },
    decre(state) {
      state.vuexCounter--;
    }
  }
})

export default store