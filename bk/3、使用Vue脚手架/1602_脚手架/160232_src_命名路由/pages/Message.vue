<template>
  <div>
    <ul>
      <li v-for="message in messageList" :key="message.id">
        <router-link
          :to="{
            name:'xiangxi',
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
