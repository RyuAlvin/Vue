<template>
  <!-- <transition name="todo" appear> -->
    <li>
      <label>
        <!-- <input type="checkbox" :checked="todo.done" @click="checkHandle(todo.id)" /> -->
        <input
          type="checkbox"
          :checked="todo.done"
          @change="handleCheck(todo.id)"
        />
        <!-- 
        改变对象中的属性数据并不会被Vue监视发现（即不会报错），
          但是仍然不建议这么使用，因为有点违法原则，因为修改了props
        -->
        <!-- <input type="checkbox" v-model="todo.done" /> -->
        &nbsp;
        <span v-show="!todo.isEdit">{{ todo.title }}</span>
        <input
          type="text"
          :value="todo.title"
          v-show="todo.isEdit"
          ref="inputTitle"
          @blur="handleBlur(todo, $event)"
        />
      </label>
      <!-- <button class="btn btn-danger" :style="displayObj" @click="deleteHandle(todo.id)">删除</button> -->
      <button class="btn btn-danger" @click="handleDelete(todo.id)">
        删除
      </button>
      <button
        class="btn btn-edit"
        v-show="!todo.isEdit"
        @click="handleEdit(todo)"
      >
        编辑
      </button>
    </li>
  <!-- </transition> -->
</template>

<script>
import pubsub from "pubsub-js";
export default {
  name: "MyItem",
  // props: ["todo", "checkTodo", "deleteTodo"],
  props: ["todo"],
  methods: {
    handleCheck(id) {
      // this.checkTodo(id);
      this.$bus.$emit("checkTodo", id);
    },
    handleDelete(id) {
      if (confirm("确定删除吗？"))
        // this.deleteTodo(id);
        // this.$bus.$emit("deleteTodo", id);
        pubsub.publish("deleteTodo", id);
    },
    handleEdit(todo) {
      if (!todo.hasOwnProperty("idEdit")) {
        this.$set(todo, "isEdit", true);
      }
      this.$nextTick(function () {
        this.$refs.inputTitle.focus();
      });
    },
    handleBlur(todo, e) {
      todo.isEdit = false;
      if (!e.target.value.trim()) {
        return alert("输入不能为空！");
      }
      console.log("hello");
      this.$bus.$emit("updateTodo", todo.id, e.target.value.trim());
    },
  },
  // computed: {
  //   displayObj() {
  //     if (this.todo.done) {
  //       return { display: "inline" };
  //     } else {
  //       return { display: "none" };
  //     }
  //   },
  // },
};
</script>

<style scoped>
/*item*/
li {
  list-style: none;
  height: 36px;
  line-height: 36px;
  padding: 0 5px;
  border-bottom: 1px solid #ddd;
}

li label {
  float: left;
  cursor: pointer;
}

li label li input {
  vertical-align: middle;
  margin-right: 6px;
  position: relative;
  top: -1px;
}

li button {
  float: right;
  display: none;
  margin-top: 3px;
}
li:hover {
  background-color: #ddd;
}

li:hover button {
  display: inline;
}

li:before {
  content: initial;
}

li:last-child {
  border-bottom: none;
}

/* .todo-enter-active {
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
} */
</style>
