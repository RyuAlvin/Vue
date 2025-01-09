// 通过CommonJS规范导出

// module.exports = {
//   add(num1, num2) {
//     return num1 + num2;
//   }
// }

exports.add = function (num1, num2) {
  return num1 + num2;
}

exports.multiply = function (num1, num2) {
  return num1 * num2;
}