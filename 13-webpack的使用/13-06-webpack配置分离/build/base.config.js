const path = require('path');
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  entry: './src/main.js',
  output: {
    path: path.resolve(__dirname, '../dist'),
    filename: 'bundle.js',
    // 打包输出的时候会自动帮我们加上 bundle.js 的引用，但是会自动加上 webpack.config.js 中的 publicPath: 'dist/' 路径， dist/bundle.js路径不对，所以需要删掉 publicPath: 'dist/' 配置
    // publicPath: 'dist/'
  },
  plugins: [
    /**
     * 为打包的文件添加版权声明，属于webpack自带的插件，所以在用的时候需要导入webpack
     * 打包后，bundle.js的头部带有版权信息
     */
    new webpack.BannerPlugin('最终版权归ryualvin所有'),
    /**
     * 我们的index.html是存放在项目的根目录下，但在真实发布项目时，发布的是dist文件夹中的内容，但是dist文件夹中如果没有index.html文件，那么打包的js等文件也就没有意义了
     * 所以，我们需要将index.html文件打包到dist文件夹中，这个时候就可以使用HtmlWebpackPlugin插件：
     *    npm install --save-dev html-webpack-plugin@3.2.0
     * HtmlWebpackPlugin插件可以为我们做这些事情：
     *    自动生成一个index.html文件（可以指定模板来生成）
     *    将打包的js文件，自动通过script标签插入到body中
     */
    new HtmlWebpackPlugin({
      template: 'index.html'
    })
  ],
  module: {
    rules: [
      {
        test: /\.vue$/, // 匹配 .vue 文件
        /**
         * "vue-loader": "^15.4.2"，webpack打包时报错：
         *    vue-loader was used without the corresponding plugin. Make sure to include VueLoaderPlugin in your webpack config.
         * 原因：
         *    vue-loader 15及以上版本需要导入VueLoaderPlugin否则会抛出这个错误。
         *    VueLoaderPlugin 是vue-loader提供的插件，用于处理.vue文件的解析和编译工作。
         */
        use: ['vue-loader']
      },
      {
        // 早期DOS系统支持的后缀名最大只有3位，所以早期只有jpg，后来Windows，Linux系统出来后可以扩展更多位数的后缀名，所以就有有了jpeg格式的
        test: /\.(png|jpg|gif|svg|jpeg)$/,
        use: [
          {
            loader: 'url-loader',
            options: {
              /**
               * 图片文件大小不能超过8192B，即8KB
               * vuelog5kb.jpg 为limit以下的文件，可以通过url-loader转为Base64内联到bundle中
               */
              limit: 8192,
            },
          },
        ],
      },
      {
        // webpack打包的bundle.js文件中（任意搜索const），发现写的ES6语法并没有转成ES5，那么就意味着可能一些对ES6还不支持的浏览器没有办法很好的运行我们的代码。
        test: /\.js$/,
        /**
         * 排除以下目录，不对其进行ES5的转化
         * 第三方库通常已经是编译过的代码，不需要再次通过babel转译，排除这些文件可以提高打包效率
         */
        exclude: /(node_modules|bower_components)/,
        use: {
          loader: 'babel-loader',
          options: {
            /**
             * 表示使用 Babel 的 ES2015 预设，它会将 ES2015 的新特性（如箭头函数、模板字符串、解构赋值等）转译为兼容旧浏览器的 ES5 代码。
             * 例如下转译：
             * const greet = () => {
             *   console.log('Hello, World!');
             * };
             * greet();
             * 
             * ->
             * 
             * 'use strict';
             * var greet = function greet() {
             *   console.log('Hello, World!');
             * };
             * greet();
             */
            presets: ['es2015'],
          },
        },
      }
    ]
  },
  // resolve配置是用来告诉webpack如何解析模块的导入路径。
  resolve: {
    // extensions用来指定当导入模块时，自动解析哪些文件扩展名的。它可以帮助我们在导入模块时省略文件的扩展名。
    extensions: ['.vue', '.js'],
    /**
     * alias是resolve的一个选项，用于定义模块的路径别名。
     * 可以帮助你在导入模块时使用更简短的路径，或者明确指定特定版本的模块。
     */
    alias: {
      /**
       * 'vue$'表示将vue的模块名限定为匹配完整的vue名称，
       * 当在main.js中导入import Vue from 'vue'时，webpack会将它解析为vue/dist/vue.esm.js
       * vue.esm.js是vue.js提供的一个模块版本，包含了完整功能的 模块编译器 和 运行时
       * 
       * 当我们不指定vue.esm.js的时候，import Vue from 'vue'可能会引用vue的运行时构建版本，即vue.runtime.esm.js，
       *  它不包含 模板编译器 ，所以运行后，在控制台会出现以下错误：
       *  bundle.js:904 [Vue warn]: 
       *    You are using the runtime-only build of Vue where the template compiler is not available. 
       *    Either pre-compile the templates into render functions, or use the compiler-included build.
       * 
       * vue为什么是运行时依赖，主要是因为vue是在项目运行时提供核心功能的框架，而不是仅仅用于开发环境的工具。
       *   "dependencies": {
       *      "vue": "^2.5.21"
       *   },
       */
      'vue$': 'vue/dist/vue.esm.js'
    }
  }
};