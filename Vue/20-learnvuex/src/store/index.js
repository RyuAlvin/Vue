import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  state:{
    vuexCounter: 0,
    students: [
      { id: 1, name: 'ryu', grade: 85 },
      { id: 2, name: 'alvin', grade: 80 },
      { id: 3, name: 'tom', grade: 60 },
      { id: 4, name: 'gary', grade: 98 },
      { id: 5, name: 'miyu', grade: 75 },
    ]
  },
  mutations: {
    incre(state) {
      state.vuexCounter++;
    },
    decre(state) {
      state.vuexCounter--;
    }
  },
  getters: {
    getStudensCount(state){
      return state.students.length;
    },
    getAvrGrade(state, getters) {
      return state.students.reduce((pre, cur) => pre + cur.grade, 0) / getters.getStudensCount
    },
    getCalcStudents(state) {
      return function(grade) {
        return state.students.filter(x => x.grade > grade).length;
      }
    }
  }
})

export default store