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
  /**
   * y，yy，yyy，yyyy，y的一个或者多个
   * y+：匹配1次或者多次
   * y?：匹配0次或者1次
   * y*：匹配0次或者多次
   * (y+)：带捕获分组的模式，
   *    即在匹配字符串的时候，如果匹配到连续多个y的字符串的时候，会记录下该匹配内容，后续可通过分组引用提取
   */
  if (/(y+)/.test(fmt)) {
    /**
     * date.getFullYear()：number类型，需要先转成字符串
     * substr：从索引第几位开始截取
     *    'yyyy' => '2013'.substr(4 - 4)，即从索引0位开始截取，结果为'2013'
     *    'yy' => '2013'.substr(4 - 2)，即从索引2位开始截取，结果为'13'
     * fmt.replace(RegExp.$1, xxxx)：将'yyyy'替换为'2013'
     */
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
    // new RegExp('(M+)').test('yyyy-MM-dd hh:mm:ss')
    if (new RegExp(`(${k})`).test(fmt)) {
      /**
       * 如果是5月，str=5
       * 如果是12月，str=12
       *    格式化字符串='yyyy-M-dd hh:mm:ss'的时候，匹配到(M+)的结果为1，所以月份不做补0处理，直接设值
       *    格式化字符串='yyyy-MM-dd hh:mm:ss'的时候，匹配到(M+)的结果为2，要做补0处理
       *      str=5，('00' + '5').substr('5'.length) => '05'
       *      str=12，('00' + '12').substr('12'.length) => '12'
       */
      let str = o[k] + '';
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? str : padLeftZero(str));
    }
  }

  return fmt;
};

function padLeftZero (str) {
  return ('00' + str).substr(str.length);
};