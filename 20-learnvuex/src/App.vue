<template>
  <div id="app">
    <button @click="counter++">按钮++</button>
    <button @click="counter--">按钮--</button>
    <button @click="incre">Vuex按钮++</button>
    <button @click="decre">Vuex按钮--</button>
    <button @click="increNum(5)">按钮+5</button>
    <button @click="decreNum(5)">按钮-5</button>
    <button @click="addCountry">添加country属性</button>
    <button @click="deleteAge">删除age属性</button>
    <button @click="changeMessage">异步处理更改message</button>
    <button @click="changeMessageInRightWay">【正确的方式】异步处理更改message</button>
    <button @click="usePromise">【正确的方式】Promise异步处理更改message</button>
    <h2>message ===> {{ $store.state.message }}</h2>
    <h2>userInfo ===> {{ $store.state.userInfo }}</h2>
    <h2>App ===> {{ counter }}</h2>
    <h2>Vuexcounter ===> {{ $store.state.vuexCounter }}</h2>
    <hr/>
    <hello-vuex :counter="counter"></hello-vuex>
    <hr/>
    <h2>学生人数：{{ $store.getters.getStudensCount }}</h2>
    <h2>平均成绩：{{ $store.getters.getAvrGrade }}</h2>
    请输入指定成绩：<input type="text" v-model="grade"/>
    <h2>成绩大于{{grade}}的人有：{{ $store.getters.getCalcStudents(grade) }}人</h2>
  </div>
</template>

<script>
import HelloVuex from '@/components/HelloVuex'
import { ADD_COUNTRY, DELETE_AGE } from './store/mutations-types';

export default {
  name: 'App',
  data() {
    return {
      counter: 0,
      grade: 0
    }
  },
  components: {
    HelloVuex
  },
  methods: {
    incre(){
      this.$store.commit(INCRE);
    },
    decre(){
      this.$store.commit('decre');
    },
    increNum(num) {
      this.$store.commit('increNum', num);
    },
    decreNum(num) {
      this.$store.commit({
        type: 'decreNum',
        num
      });
    },
    addCountry() {
      this.$store.commit(ADD_COUNTRY);
    },
    deleteAge() {
      this.$store.commit(DELETE_AGE);
    },
    changeMessage() {
      this.$store.commit('changeMessage');
    },
    changeMessageInRightWay() {
      this.$store.dispatch('changeMessageInRightWay', {
        username: 'ryualvin',
        role: 'admin',
        // 异步处理结束后通知
        success: function() {
          console.log('state已经更改好了');
        }
      });
    },
    usePromise() {
      this.$store
      .dispatch('usePromise', {
        username: 'ryualvin',
        role: 'admin'
      })
      .then(res => {
        console.log('App.vue ===> ', res);
      })
    }
  },
}
</script>

<style>
</style>
