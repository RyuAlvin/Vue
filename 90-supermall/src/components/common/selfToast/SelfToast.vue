<!-- 
1、位置：因为其他项目也可复用，所以放在components/common中
2、属性：message，show（默认值：false）
3、布局：fixed居中，字体白色，背景透明黑
4、使用：
   4.1、加入购物车返回结果（resolve），设置Toast.vue的message和show
   4.2、开启定时器，回调中重置message和show 
-->
<template>
  <div class="self-toast" v-show="isShow">
    {{ message }}
  </div>
</template>

<script>
export default {
  name: 'SelfToast',
  // props: {
  //   message: {
  //     type: String,
  //     default: '哈哈哈'
  //   }
  // }
  data() {
    return {
      message: '显示默认内容',
      isShow: false
    }
  },
  methods: {
    show(message, duration = 5000) {
      // console.log('SelfToast.message => ', message);
      // console.log('SelfToast.duration => ', duration);
      this.message = message;
      this.isShow = true;
      setTimeout(() => {
        this.message = '';
        this.isShow = false;
      }, duration);
    }
  },
}
</script>

<style scoped>
.self-toast {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  padding: 10px 10px;

  color: white;
  /* red green blue alpha(透明度) */
  background-color: rgba(0, 0, 0, 0.75);

  z-index: 999;
}
</style>