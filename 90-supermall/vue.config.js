module.exports = {
  // transpileDependencies: true
  configureWebpack: {
    resolve: {
      alias: {
        'assets': '@/assets',
        'common': '@/common',
        'components': '@/components',
        'network': '@/network',
        'views': '@/views'
      }
    }
  },
  // 关闭lint检查
  lintOnSave: false
}
