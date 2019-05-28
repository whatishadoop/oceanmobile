import { initData } from '@/api/data'

/* mixins就是定义一部分公共的方法或者计算属性,然后混入到各个组件中使用,方便管理与统一修改，包括合并成数组如created ready等只会被合并，以及重写覆盖如 methods, components 和 directives 将合并到同一个对象内 */
export default {
  data() {
    return {
      loading: true, data: [], page: 0, size: 10, total: 0, url: '', params: {}, query: {}, time: 170
    }
  },
  methods: {
    async init() {
      if (!await this.beforeInit()) {
        return
      }
      return new Promise((resolve, reject) => {
        this.loading = true
        initData(this.url, this.params).then(res => {
          this.total = res.totalElements
          this.data = res.content
          // 4s后执行的效果,有渲染延迟，数据没有加载完成，此时为了防止用户进行操作，会显示一个遮罩
          setTimeout(() => {
            this.loading = false
          }, this.time)
          resolve(res)
        }).catch(err => {
          this.loading = false
          reject(err)
        })
      })
    },
    beforeInit() {
      return true
    },
    pageChange(e) {
      this.page = e - 1
      this.init()
    },
    sizeChange(e) {
      this.page = 0
      this.size = e
      this.init()
    }
  }
}
