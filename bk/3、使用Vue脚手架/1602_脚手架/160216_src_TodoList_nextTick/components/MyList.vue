<template>
  <ul class="todo-main">
    <!-- <MyItem
      v-for="todoObj in todos"
      :key="todoObj.id"
      :todo="todoObj"
      :checkTodo="checkTodo"
      :deleteTodo="deleteTodo"
    /> -->
    <MyItem v-for="todoObj in todos" :key="todoObj.id" :todo="todoObj" />
  </ul>
</template>

<script>
import MyItem from "./MyItem.vue";
export default {
  name: "MyList",
  // data() {
  //   return {
  //     todos: [
  //       { id: "001", title: "游泳", done: true },
  //       { id: "002", title: "开车", done: false },
  //       { id: "003", title: "敲代码", done: true },
  //     ],
  //   };
  // },
  components: {
    MyItem,
  },
  // props: ["todos", "checkTodo", "deleteTodo"],
  props: ["todos"],
};
</script>

<style scoped>
/*main*/
.todo-main {
  margin-left: 0px;
  border: 1px solid #ddd;
  border-radius: 2px;
  padding: 0px;
}

.todo-empty {
  height: 40px;
  line-height: 40px;
  border: 1px solid #ddd;
  border-radius: 2px;
  padding-left: 5px;
  margin-top: 10px;
}
</style>
