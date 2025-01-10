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
 * 打包css文件，首先需要依赖css文件
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

/**
 * 打包less文件，首先需要依赖less文件
 * 1、先安装打包less文件时，需要的Node.js的包
 *    npm install --save-dev less-loader@4.1.0
 *      less-loader和css-loader加载css资源一样，是用来加载less文件
 *    npm install --save-dev less@3.9.0
 *      less和style-loader解析css资源一样，是用来解析less文件
 * 2、在webpack.config.js出口中配置关于less模块的解析规则
 * 3、执行 npm run build
 */
require('./css/special.less')

document.writeln('<p>Hello World!</p>')