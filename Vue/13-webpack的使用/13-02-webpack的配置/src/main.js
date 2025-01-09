// 通过CommonJS规范导入

// const math = require('./mathUtil.js')
// console.log(math.add(1, 2));
// console.log(math.multiply(1, 2));

const { add, multiply } = require('./mathUtil.js');
console.log('mathUtil.js ---> add: ', add(1, 2));
console.log('mathUtil.js ---> multiply: ', multiply(1, 2));

import { name, age } from './info.js'
console.log('info.js ---> name: ', name);
console.log('info.js ---> age: ', age);