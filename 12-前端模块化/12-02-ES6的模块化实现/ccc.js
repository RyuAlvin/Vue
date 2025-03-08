// 方式一：
import { flag } from './aaa.js'

if (flag) {
  console.log('Hello ccc.js');
}

// 方式二：
import { name } from './aaa.js'
console.log(name);

// 方式三：
import { num1, num2, sum } from './aaa.js'
console.log(sum(num1, num2));

// 方式四：
import { Person } from './aaa.js'
const alvin = new Person('alvin', 20);
alvin.greet();

import { Animal } from './aaa.js'
const tiger = new Animal('tiger', 18);
tiger.run();

// 方式五
// 对于默认导出，导入时可以用任意名称

// import counter from './aaa.js'
// console.log(counter);

// import multiply from './aaa.js'
// console.log(multiply(20, 30));

import Obj from './aaa.js'
const obj = new Obj('alvin', 35);
obj.sayHi();

// 统一全部导入
import * as aaa from './aaa.js'
console.log(`flag：${aaa.flag}`);
console.log(`name：${aaa.name}`);
console.log(`name：${aaa.name}`);


