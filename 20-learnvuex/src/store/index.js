import Vue from 'vue'
import Vuex from 'vuex'
import mutations from './mutations';
import actions from './actions';
import getters from './getters';
import user from './modules/user';

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    user
  },
  state:{
    vuexCounter: 0,
    students: [
      { id: 1, name: 'ryu', grade: 85 },
      { id: 2, name: 'alvin', grade: 80 },
      { id: 3, name: 'tom', grade: 60 },
      { id: 4, name: 'gary', grade: 98 },
      { id: 5, name: 'miyu', grade: 75 },
    ],
    userInfo: {
      name: 'ryualvin',
      age: 20,
      sex: 'male'
    },
    message: 'Hello World'
  },
  mutations,
  actions,
  getters
})

export default store