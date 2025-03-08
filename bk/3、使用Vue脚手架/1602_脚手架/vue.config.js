const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  // 开启代理服务器，这种方式不能开启多台代理
  // devServer: {
  //   proxy: 'http://localhost:5000'
  // }
});
