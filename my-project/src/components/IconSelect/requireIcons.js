/**
 * require.context是webpack中，用来创建自己的（模块）上下文
 * require.context函数接收三个参数：
 * a.要搜索的文件夹目录
 * b.是否还应该搜索它的子目录
 * c.以及一个匹配文件的正则表达式
 */
const req = require.context('../../icons/svg', false, /\.svg$/)
// req式个函数，里面的keys属性以数组形式封装多个svg
const requireAll = requireContext => requireContext.keys()

const re = /\.\/(.*)\.svg/

// 对数组进行正则匹配，过滤掉不是svh的图片
const icons = requireAll(req).map(i => {
  return i.match(re)[1]
})

export default icons
