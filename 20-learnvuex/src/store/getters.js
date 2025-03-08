export default {
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