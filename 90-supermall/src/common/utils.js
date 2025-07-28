/**
 * 1、什么是防抖函数:
 *    一种用于限制函数执行频率的技术，
 *    它可以确保一个函数在一定事件内只执行一次，
 *    或者在最后一次调用后经过指定时间才执行。
 * 2、为什么要做防抖函数：
 *    每次图片加载完成都要调用refresh的话，执行频率太高。
 *    最好能有一个延时操作，在第一次加载后间隔一定事件再refresh。
 * 3、防抖函数结构：
 *    对真正想要执行的函数进行防抖。
 * 4、防抖函数(目标函数, 间隔时间)
 * @param func 
 * @param delay 
 */
export function debounce(func, delay) {
  let timer = null;
  /**
   * 首先，debounce属于外层函数，嵌套一个内层函数，
   *  且内层函数引用了debounce外层函数的变量timer，所以内存函数能够始终保存timer的作用域链
   * 
   * 假设延迟时间为3秒
   * 当第一张照片加载完成的时候
   *    timer=null
   *    此时设置一个定时器赋值给timer，然后开始读秒，
   * 当时间过去200毫秒的时候，第二张照片加载完成
   *    第一张照片加载完成启动的timer被清空
   *    此时设置一个新的定时器赋值给timer，然后开始读秒
   * ...
   * 当最后一张照片加载完成的时候
   *    timer被清空
   *    设置一个新的定时器赋值给timer，然后开始读秒
   *    时间结束后执行refresh函数，有且仅有一次
   */
  return function(...args) {
    if(timer) clearTimeout(timer);
    /**
     * setTimeout的执行时机
     *    当启动一个定时器的是偶，它的回调会被放入任务队列
     *    只有当前调用栈清空 且 主线程空闲时，事件循环才会从队列中取出回调函数
     */
    timer = setTimeout(() => {
      /**
       * apply是函数对象的一个方法，用于调用函数时动态指定this值和参数数组。
       *    非严格模式下：null或undefined会自动替换为全局对象（如window）。
       *    严格模式下：null或undefined会直接作为this值。
       */
      func.apply(this, args);
    }, delay);
  }
}

export function formatDate(date, fmt) {
  if (/(y+)/.test(fmt)) {
    fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));
  }

  let o = {
    'M+': date.getMonth() + 1,
    'd+': date.getDate(),
    'h+': date.getHours(),
    'm+': date.getMinutes(),
    's+': date.getSeconds()
  };

  for (let k in o) {
    if (new RegExp(`(${k})`).test(fmt)) {
      let str = o[k] + '';
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? str : padLeftZero(str));
    }
  }
  
  return fmt;
};

function padLeftZero (str) {
  return ('00' + str).substr(str.length);
};