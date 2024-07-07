<template>
  <div class="todo-footer" v-show="total">
    <label>
      <!-- <input type="checkbox" :checked="isAll" @change="checkAll" /> -->
      <input type="checkbox" v-model="isAll" />
    </label>
    <span>
      <span>已完成{{ doneTotal }}</span> / 全部{{ total }}
    </span>
    <button class="btn btn-danger" @click="clearAll" v-show="doneTotal">
      清除已完成任务
    </button>
  </div>
</template>

<script>
export default {
  name: "MyFooter",
  // props: ["todos", "checkAllTodo", "clearTodo"],
  props: ["todos"],
  data() {
    return {
      chk: true,
    };
  },
  computed: {
    total() {
      return this.todos.length;
    },
    doneTotal() {
      /**
       * 这种情况输出的是0,undefined,undefined
       *  没有return，在执行第2次处理的时候，第一次执行的结果则为undefined
       */
      // this.todos.reduce((previous, current, index) => {
      //   console.log("@previous-" + previous);
      // }, 0);
      return this.todos.reduce(
        (previous, todo) => previous + (todo.done ? 1 : 0),
        0
      );
    },
    /**
     * <input type="checkbox" :checked="isAll" @change="checkAll" />
     */
    // isAll() {
    //   return this.doneTotal == this.total && this.total > 0;
    // },

    isAll: {
      get() {
        return this.doneTotal == this.total && this.total > 0;
      },
      set(value) {
        // this.checkAllTodo(value);
        this.$emit('checkAllTodo',value);
      },
    },
  },
  methods: {
    /**
     * <input type="checkbox" :checked="isAll" @change="checkAll" />
     */
    // checkAll(e) {
    //   this.checkAllTodo(e.target.checked);
    // },
    clearAll() {
      if (this.doneTotal > 0 && confirm("是否清楚所有已完成任务？"))
        this.$emit('clearTodo');
    },
  },
};
</script>

<style scoped>
/*footer*/
.todo-footer {
  height: 40px;
  line-height: 40px;
  padding-left: 6px;
  margin-top: 5px;
}

.todo-footer label {
  display: inline-block;
  margin-right: 20px;
  cursor: pointer;
}

.todo-footer label input {
  position: relative;
  top: -1px;
  vertical-align: middle;
  margin-right: 5px;
}

.todo-footer button {
  float: right;
  margin-top: 5px;
}
</style>
