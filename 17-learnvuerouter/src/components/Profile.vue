<template>
  <div>
    <h1>Hello, This is Profile</h1>
    <h2>{{ $route.query }}</h2>
    <h2>{{ $route.query.id }}</h2>
    <h2>{{ $route.query.name }}</h2>
    <h2>{{ $route.query.age }}</h2>
    <button @click="btnClick">按钮</button>
  </div>
</template>

<script>
export default {
  methods: {
    btnClick() {
      // 所有的组件都继承自Vue的原型
      this.sayHi();
    }
  },
}
</script>

<style>

</style>