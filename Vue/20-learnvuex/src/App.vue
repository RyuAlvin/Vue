<template>
  <div id="app">
    <button @click="counter++">按钮++</button>
    <button @click="counter--">按钮--</button>
    <button @click="incre">Vuex按钮++</button>
    <button @click="decre">Vuex按钮--</button>
    <h2>App ===> {{ counter }}</h2>
    <h2>Vuexcounter ===> {{ $store.state.vuexCounter }}</h2>
    <hr/>
    <hello-vuex :counter="counter"></hello-vuex>
  </div>
</template>

<script>
import HelloVuex from '@/components/HelloVuex'

export default {
  name: 'App',
  data() {
    return {
      counter: 0
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
    }
  },
}
</script>

<style>
</style>
