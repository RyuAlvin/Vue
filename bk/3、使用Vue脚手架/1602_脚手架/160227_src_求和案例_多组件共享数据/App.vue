<template>
  <div>
    <Count />
    <hr />
    <Person />
  </div>
</template>

<script>
import Count from "./components/Count.vue";
import Person from "./components/Person.vue";
export default {
  name: "App",
  components: {
    Count,
    Person,
  },
};
</script>

<style>
h2 {
  color: red;
}
hr{
  height: 1px;
  background-color: black;
}
</style>
