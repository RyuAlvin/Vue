<template>
  <div>
    <ul>
      <li v-for="message in messageList" :key="message.id">
        <router-link
          :to="{
            name: 'xiangxi',
            query: {
              id: message.id,
              title: message.title,
            },
          }"
        >
          {{ message.title }}
        </router-link>
        &nbsp;&nbsp;
        <button @click="pushShow(message)">push显示</button>
        <button @click="replaceShow(message)">replace显示</button>
      </li>
    </ul>
    <hr />
    <router-view></router-view>
  </div>
</template>

<script>
import { nanoid } from "nanoid";
export default {
  name: "Message",
  data() {
    return {
      messageList: [
        { id: nanoid(), title: "message001" },
        { id: nanoid(), title: "message002" },
        { id: nanoid(), title: "message003" },
      ],
    };
  },
  methods: {
    /**
     * 不借助<router-link>实现路由跳转，让路由跳转更加灵活
     *  不仅仅局限于使用a标签
     */
    pushShow(message) {
      this.$router.push({
        name: "xiangxi",
        query: {
          id: message.id,
          title: message.title,
        },
      });
    },
    replaceShow(message) {
      this.$router.replace({
        name: "xiangxi",
        query: {
          id: message.id,
          title: message.title,
        },
      });
    },
  },
  beforeDestroy(){
    console.log('Message组件即将被销毁')
  }
};
</script>

<style scoped>
hr {
  background-color: black;
  height: 1px;
}
</style>
