/**
 * 只保留生产相关的js压缩配置
 */
const UglifyJsPlugin = require('uglifyjs-webpack-plugin');
// 安装 npm install --save-dev webpack-merge@4.1.5
const WebpackMerge = require('webpack-merge')
const baseConfig = require('./base.config')
// 合并base.config.js
module.exports = WebpackMerge(baseConfig, {
  plugins: [
    // 报错!!!!!!!!!!!!!!!!!!!!!!!!!!，跳过~
    new UglifyJsPlugin()
  ]
})