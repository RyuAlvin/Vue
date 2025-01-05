// 方式一：先定义变量，后导出
var flag = true;
export {
  flag
};

// 方式二：定义后直接导出
export var name = 'ryualvin';

// 方式三：导出函数
let num1 = 20;
let num2 = 30;
function sum(num1, num2) {
  return num1 + num2;
}
export { num1, num2, sum };

// 方式四：导出类（构造函数）
// 定义构造函数
function Person(name, age) {
  this.name = name;
  this.age = age;
}
// 定义原型方法
Person.prototype.greet = function () {
  console.log(`Hello Person, name:${this.name}, age:${this.age}`);
}
export { Person };

// 方式四：导出类（class）
export class Animal {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }
  run() {
    console.log(`${this.name} is ${this.age}, running ...`);
  }
};

// 方式五：指定导出内容，不指定名称（由导入方指定），一个模块只能由一个默认导出
// export default 200;
// export default function (num1, num2) {
//   return num1 * num2;
// }
export default class {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }
  sayHi() {
    console.log(`Hi, my name is ${this.name}, i am ${this.age}`);
  }
}