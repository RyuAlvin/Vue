/**
 * 只保留开发相关的本地服务器配置
 */
// 安装 npm install --save-dev webpack-merge@4.1.5
const WebpackMerge = require('webpack-merge')
const baseConfig = require('./base.config')
// 合并base.config.js
module.exports = WebpackMerge(baseConfig, {
  devServer: {
    // 为哪一个文件夹提供本地服务，默认是根文件夹，我们这里要填写./dist
    contentBase: './dist',
    // 页面实时刷新
    inline: true,
    // 端口号
    // port: 
    // 在SPA页面中，依赖HTML5的history模式
    // historyApiFallback:
  }
})