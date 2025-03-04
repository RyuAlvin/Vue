<template>
  <div id="app">
    <button @click="counter++">按钮++</button>
    <button @click="counter--">按钮--</button>
    <h2>App ===> {{ counter }}</h2>
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
  }
}
</script>

<style>
</style>
