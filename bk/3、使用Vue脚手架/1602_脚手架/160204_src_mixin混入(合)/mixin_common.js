/**
 *  功能：可以把多个组件共用的配置提取成一个混入对象
 *  使用方式：
 *      第一步定义混合，例如：
 *          {
 *              data(){ ... },
 *              methods:{ ... },
 *              ...
 *          }
 *      第二步使用混入，例如：
 *          （1）、全局混入：Vue.mixin(xxx)
 *          （2）、局部混入：mixins:['xxx']
 */

//分别暴露
//局部混入
export const m = {
  methods: {
    showName() {
      console.log(this.name);
    },
  },
};

export const n = {
  mounted() {
    console.log("挂载完毕");
  },
};
