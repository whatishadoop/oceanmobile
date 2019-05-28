export default {
  install: function(Vue) {
    // 全局异步注册组件
    Vue.component('barchart', () => import('@/views/appmanage/components/chart/barchart'))

    // 全局异步注册配置组件
    Vue.component('barchartconfig', () => import('@/views/appmanage/components/chart/barchartconfig'))
    Vue.component('barchartconfig02', () => import('@/views/appmanage/components/chart/barchartconfig02'))
  }
}
