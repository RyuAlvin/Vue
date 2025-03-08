<template>
  <div id="school">
    <h2>{{ name }}</h2>
    <button @click="sendSchoolName">显示学校名字</button>
  </div>
</template>

<script>
export default {
  name: "School",
  data() {
    return {
      name: "xxxx大学",
    };
  },
  props: ["getSchoolName"],
  methods: {
    sendSchoolName() {
      this.getSchoolName(this.name);
    },
  },
};
</script>

<style scoped>
#school {
  height: 100px;
  background-color: cornflowerblue;
}
</style>
