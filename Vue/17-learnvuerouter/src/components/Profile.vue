<template>
  <div>
    <h1>Hello, This is Profile</h1>
    <h2>{{ $route.query }}</h2>
    <h2>{{ $route.query.id }}</h2>
    <h2>{{ $route.query.name }}</h2>
    <h2>{{ $route.query.age }}</h2>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>