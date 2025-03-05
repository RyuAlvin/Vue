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
    ],
    userInfo: {
      name: 'ryualvin',
      age: 20,
      sex: 'male'
    }
  },
  mutations: {
    incre(state) {
      state.vuexCounter++;
    },
    decre(state) {
      state.vuexCounter--;
    },
    increNum(state, num) {
      state.vuexCounter += num;
    },
    decreNum(state, payload) {
      state.vuexCounter -= payload.num;
    },
    addCountry(state) {
      // 在DevTools中可以看到userInfo中是多了country这个属性，但是页面没有反映，这种添加属性的方式不是响应式
      state.userInfo.country = 'China';
    },
    deleteAge(state) {
      // 在DevTools中可以看到userInfo中是少了age这个属性，但是页面没有反映，这种删除属性的方式不是响应式
      delete state.userInfo.age;
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