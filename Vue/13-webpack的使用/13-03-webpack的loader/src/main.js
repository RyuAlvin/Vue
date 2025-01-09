// 通过CommonJS规范导入

// const math = require('./mathUtil.js')
// console.log(math.add(1, 2));
// console.log(math.multiply(1, 2));

const { add, multiply } = require('./js/mathUtil.js');
console.log('mathUtil.js ---> add: ', add(1, 2));
console.log('mathUtil.js ---> multiply: ', multiply(1, 2));

import { name, age } from './js/info.js'
console.log('info.js ---> name: ', name);
console.log('info.js ---> age: ', age);

/**
 * 依赖css文件
 * 执行 npm run build 命令打包，报错：
 * ERROR in ./src/css/normal.css
 * Module parse failed: D:\develop\project\rensyu\Vue\13-webpack的使用\13-03-webpack的loader\src\css\normal.css Unexpected token (1:5)
 * You may need an appropriate loader to handle this file type.
 * | body {
 * |   background-color:aqua;
 * | }
 * 
 * 解决：
 *  1、安装css-loader，style-laoder
 *      npm install --save-dev css-loader@0.28.11 style-loader@0.23.1
 *      因为webpack@3.6.0只能适配以上版本
 *  2、在webpack.config.js中配置loader
 *  3、执行 npm run build
 */
require('./css/normal.css')