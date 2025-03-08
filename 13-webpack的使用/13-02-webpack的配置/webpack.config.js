// 注意，是'path'，不是'./path'。'./path'是去项目路径下找对应的模块。'path'的话就不是我们自己写的模块了，得去node包下找了，所以需要通过npm安装node包。
const path = require('path')

// 执行 webpack 命令（不带参数）的时候，会到根目录找webpack.config.js文件，我们只需要在webpack.config.js文件中定义好入口和出口，webpack就会帮我们打包。
module.exports = {
  // 入口
  entry: './src/main.js',

  // 出口
  // 不建议这么写
  // output: './dist/bundle.js'
  output: {
    /**
     * 执行 webpack 命令报错，提示需要指定绝对路径。
     * Invalid configuration object. Webpack has been initialised using a configuration object that does not match the API schema.
     * - configuration.output.path: The provided value "./dist" is not an absolute path!
     * 虽然可以通过指定本地的绝对路径让 webpack 命令执行成功，但是，但是！一旦项目发布，或者从远端拉取项目，难道都要每次去更改绝对路径吗？
     * 不不不，我们需要动态的获取路径。
     * 解决方案：我们可以通过导入path模块【const path = require('path')】，path模块提供了一个resolve方法会帮我们构成绝对路径。
     * 但前提是，我们需要通过npm帮我们安装path包，我们才有办法导入。
     * 一旦我们需要用到node包的时候，我们最好执行 npm init 命令做一个初始化，执行后，会帮我们生成package.json文件
     */
    // path: './dist',
    /**
     * node初始化后有了package.json文件后，就可以使用path包了，不用做额外的导入。
     * 因为path属于Node.js的内置核心模块，构建了Node项目以后，直接引入就能用了。
     * __dirname是Node.js中的一个全局变量，返回当前文件所在目录的绝对路径
     * 这时候执行 webpack 就不会报错，并且能够成功打包。
     * 
     * 但是，但是！！！这时候执行的 webpack 调用的是Node.js全局变量下的webpack包（该版本可能和我们想要的版本不一致）。
     * 我们需要通过 npm install webpack@3.6.0 --save-dev 为当前项目指定想要的版本。
     * 然后再通过以下方式执行 webpack：
     *  1、./node_modules/webpack
     *  2、npm run build
     */
    path: path.resolve(__dirname, 'dist'),
    filename: 'bundle.js'
  }
}