<template>
  <div>
    <ul>
      <li v-for="message in messageList" :key="message.id">
        <!-- 
          跳转并携带params参数方式一：，to的字符串写法
         -->
        <!-- <router-link
          :to="`/Home/Message/Detail/${message.id}/${message.title}`"
          >{{ message.title }}</router-link
        > -->
        <!-- 
          跳转并携带params参数方式一：，to的对象写法
          特别注意：路由携带params参数时，若使用to的对象写法，
                    则不能使用path配置项，必须使用name配置！
         -->
        <router-link
          :to="{
            name: 'xiangxi',
            query: {
              id: message.id,
              title: message.title,
              a:'Hey',
              b:'Yo'
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
