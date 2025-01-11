const path = require('path');

module.exports = {
  entry: './src/main.js',
  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: 'bundle.js'
  },
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
      }
    ]
  },
  // resolve配置是用来告诉webpack如何解析模块的导入路径。
  resolve: {
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