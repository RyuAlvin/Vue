; var obj = (function () {
  var flag = true;
  var jsName = 'aaa';

  if (flag) {
    console.log(jsName);
  }

  return {
    flag
  }
})();


// CommonJS导出例
// module.exports = {
//   add(a, b) {
//     return a + b;
//   }
// }