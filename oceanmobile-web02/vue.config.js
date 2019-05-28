module.exports = {
  lintOnSave: false,
  css: {
    loaderOptions: {
      css: {},
      /*postcss: {
        plugins: [
          require('postcss-px2rem')({
            remUnit: 37.5
          })
        ]
      }*/
    }
  },
  devServer: {
    port: 8013, // 端口号
    host: 'localhost',
    https: false, // https:{type:Boolean}
    open: true, //配置自动启动浏览器
  },
}
