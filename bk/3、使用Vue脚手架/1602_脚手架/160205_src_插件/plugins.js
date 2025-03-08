import { m, n } from "./mixin";

export default {
  install(Vue, x, y, z) {
    console.log("Hello World !");
    console.log("x = > " + x);
    console.log("y = > " + y);
    console.log("z = > " + z);

    Vue.filter("mySlice", function (val) {
      return val.slice(0, 4);
    });

    Vue.directive("fbind", {
      // 指令与元素成功绑定时（一上来）
      bind(element, binding) {
        element.value = binding.value;
      },
      // 指令所在元素被插入页面时
      inserted(element, binding) {
        element.focus();
      },
      // 指令所在的模版被重新解析时
      update(element, binding) {
        element.value = binding.value;
      },
    });

    Vue.mixin(m);
    Vue.mixin(n);
    Vue.mixin({
      data() {
        return {
          x: "哈哈",
          y: "嘿嘿",
        };
      },
    });

    Vue.prototype.demo = () => {
      console.log("你好");
    };
  },
};
