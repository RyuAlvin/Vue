<template>
  <div id="app">
    <button @click="counter++">按钮++</button>
    <button @click="counter--">按钮--</button>
    <button @click="incre">Vuex按钮++</button>
    <button @click="decre">Vuex按钮--</button>
    <button @click="increNum(5)">按钮+5</button>
    <button @click="decreNum(5)">按钮-5</button>
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
      this.$store.commit('incre');
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
    }
  },
}
</script>

<style>
</style>
