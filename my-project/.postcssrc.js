// https://github.com/michael-ciniawsky/postcss-load-config

module.exports = {
  "plugins": {
    "postcss-import": {},
    "postcss-url": {},
    // to edit target browsers: use "browserslist" field in package.json
    "autoprefixer": {},
    "postcss-plugin-px2rem": {
      rootValue: 54,
      unitPrecision: 2, // 保留2位rem精度
      mediaQuery: true,
      exclude:"/node_modules/",
      selectorBlackList: ['html', 'mint-', 'mt-', 'mpvue-', 'calendar', 'iconfont'], //   排除指定的文件的不转换为rem影响，使用正则表达式
      propBlackList: ['border'] // 哪些属性不进行转换，
    }
  }
}
