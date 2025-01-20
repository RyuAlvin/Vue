<template>
  <div id="app">
    <!-- <router-link to="/home">Home</router-link> <router-link to="/about">About</router-link><br/> -->

    <!-- router-link默认渲染成a标签，可用tag属性指定想要渲染的标签种类 -->
    <!-- <router-link to="/home" tag="button">Home</router-link> <router-link to="/about" tag="button">About</router-link><br/> -->

    <!-- vue-router指定html5的history模式后，默认使用pushState进行跳转，页面上可通过前进后退控制，若想禁用前进后退，只靠路由跳转，即replaceState方式。可通过replace属性实现 -->
    <!-- <router-link to="/home" replace>Home</router-link> <router-link to="/about" replace>About</router-link><br/> -->

    <!-- 当路由被点击时，默认会被添加上"router-link-active"类，我们可通过该类指定active样式，可通过active-class属性指定被点击时要添加的类的名字 -->
    <!-- <router-link to="/home" active-class="active">Home</router-link> <router-link to="/about" active-class="active">About</router-link><br/> -->

    <!-- 为避免批量修改active-class，可在router/index.js中一次性更改 -->
    <!-- <router-link to="/home" active-class="active">Home</router-link> <router-link to="/about" active-class="active">About</router-link><br/> -->
    <!-- <router-link to="/home" active-class="active">Home</router-link> <router-link to="/about" active-class="active">About</router-link><br/> -->
    <!-- <router-link to="/home" active-class="active">Home</router-link> <router-link to="/about" active-class="active">About</router-link><br/> -->
    <!-- <router-link to="/home" active-class="active">Home</router-link> <router-link to="/about" active-class="active">About</router-link><br/> -->

    <!-- <router-link to="/home">Home</router-link> <router-link to="/about">About</router-link><br/> -->

    <button @click="linkToHome">Home</button
    ><button @click="linkToAbout">About</button>

    <!-- 动态拼接传递参数 -->
    <router-link :to="`/user/${userId}`">User</router-link>

    <!-- 通过query传递参数 -->
    <!-- <router-link :to="{ path: '/profile', query: { id: 'U001', name: 'ryualvin', age: 18 } }">Profile</router-link> -->
    <button @click="linkToProfile">profile</button>

    <router-view />
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      userId: "ryualvin",
    };
  },
  methods: {
    /**
     * 通过代码跳转路由
     */
    linkToHome() {
      // this.$router.push('/home');
      this.$router.replace("/home");
    },
    linkToAbout() {
      // this.$router.push('/about');
      this.$router.replace("/about");
    },
    linkToProfile() {
      this.$router.replace({
        path: "/profile",
        query: { 
          id: "U001", 
          name: "ryualvin", 
          age: 18 
        }
      });
    },
  },
};
</script>

<style>
/* .router-link-active {
  color: red; 
} */
.active {
  color: red;
}
</style>
