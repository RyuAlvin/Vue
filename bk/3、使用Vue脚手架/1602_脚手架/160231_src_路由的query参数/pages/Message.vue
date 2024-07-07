<template>
  <div>
    <ul>
      <li v-for="message in messageList" :key="message.id">
        <!-- 路由的query传参，方式一：to的字符串写法 -->
        <!-- <router-link
          :to="`/Home/Message/Detail?id=${message.id}&title=${message.title}`"
          >{{ message.title }}</router-link
        > -->

        <!-- 路由的query传参，方式二：to的对象写法 -->
        <router-link
          :to="{
            path: '/Home/Message/Detail',
            query: {
              id: message.id,
              title: message.title,
            },
          }"
        >
          {{ message.title }}
        </router-link>
        &nbsp;&nbsp;
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
};
</script>

<style scoped>
hr {
  background-color: black;
  height: 1px;
}
</style>
