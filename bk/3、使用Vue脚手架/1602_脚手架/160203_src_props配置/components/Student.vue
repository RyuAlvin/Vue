<template>
  <div>
    <h2>{{ msg }}</h2>
    <h2>学生姓名：{{ name }}</h2>
    <h2>学生年龄：{{ myAge + 1 }}</h2>
    <h2>学生性别：{{ sex }}</h2>
    <button @click="addAge">点击年龄+1</button>
  </div>
</template>

<script>
export default {
  name: "Student",
  data() {
    return {
      msg: "Hello World !",
      myAge: this.age,
    };
  },
  methods: {
    addAge() {
      this.myAge++;
    },
  },

/**
 * props是只读的，Vue底层会监测你对props的修改，如果进行了修改，就会发出警告。
 *  若业务需求却是需要修改，那么请复制props的内容到data中一份，然后去修改data中的数据。
 */

  //第一种方式：简单声明接收
  //   props: ["name", "age", "sex"],

  //第二种方式：接收的同时对数据进行类型限制
  //   props: {
  //     name: String,
  //     age: Number,
  //     sex: String,
  //   },

  //第三种方式：接收的同时对数据：进行类型限制+默认值的指定+必要性的限制
  props: {
    name: {
      type: String,
      require: true,
    },
    age: {
      type: Number,
      default: 99,
    },
    sex: {
      type: String,
      require: true,
    },
  },
};
</script>

<style></style>
