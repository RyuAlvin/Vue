/**
 * 只保留生产相关的js压缩配置
 */
const UglifyJsPlugin = require('uglifyjs-webpack-plugin');

module.exports = {
  plugins: [
    // 报错!!!!!!!!!!!!!!!!!!!!!!!!!!，跳过~
    new UglifyJsPlugin()
  ]
};