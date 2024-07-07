<template>
  <ul class="todo-main">
    <!-- <MyItem
      v-for="todoObj in todos"
      :key="todoObj.id"
      :todo="todoObj"
      :checkTodo="checkTodo"
      :deleteTodo="deleteTodo"
    /> -->
    <transition-group name="todo" appear>
      <MyItem v-for="todoObj in todos" :key="todoObj.id" :todo="todoObj" />
    </transition-group>
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

.todo-enter-active {
  animation: ryu 0.5s linear;
}

.todo-leave-active {
  animation: ryu 0.5s linear reverse;
}

@keyframes ryu {
  from {
    transform: translateX(100%);
  }
  to {
    transform: translateX(0px);
  }
}
</style>
