<template>
  <div>
    <!--/.navbar-fixed-top -->
    <div class="container">
      <div class="row">
        <div class="">
          <!--左侧组件工具栏-->
          <div class="sidebar-nav">
            <ul class="nav nav-list accordion-group">
              <li class="nav-header">
                <div class="pull-right popover-info">
                  <i class="glyphicon glyphicon-question-sign"></i>
                  <div class="popover fade right">
                    <div class="arrow"></div>
                    <h3 class="popover-title">帮助</h3>
                    <div class="popover-content">
                      xxx
                    </div>
                  </div>
                </div>
                <i class="glyphicon-plus glyphicon"></i>
                布局设置
              </li>
              <li id="estRows" class="rows">
                <div class="lyrow ui-draggable">
                  <a href="#close" class="remove label label-danger">
                    <i class="glyphicon-remove glyphicon"></i>
                    删除
                  </a>
                  <span class="drag label label-default">
								     <i class="glyphicon glyphicon-move"></i>
								      拖动
							    </span>
                  <div class="preview">
                    12
                  </div>
                  <div class="view">
                    <div class="row clearfix">
                      <div class="col-md-12 column"></div>
                    </div>
                  </div>
                </div>
                <div class="lyrow ui-draggable">
                  <a href="#close" class="remove label label-danger">
                    <i class="glyphicon-remove glyphicon"></i>
                    删除
                  </a>
                  <span class="drag label label-default">
								<i class="glyphicon glyphicon-move"></i>
								拖动
							</span>

                  <div class="preview">
                    6 6
                  </div>
                  <div class="view">
                    <div class="row clearfix">
                      <div class="col-md-6 column"></div>
                      <div class="col-md-6 column"></div>
                    </div>
                  </div>
                </div>
                <div class="lyrow ui-draggable">
                  <a href="#close" class="remove label label-danger">
                    <i class="glyphicon-remove glyphicon"></i>
                    删除
                  </a>
                  <span class="drag label label-default">
								<i class="glyphicon glyphicon-move"></i>
								拖动
							</span>

                  <div class="preview">
                    8 4
                  </div>
                  <div class="view">
                    <div class="row clearfix">
                      <div class="col-md-8 column"></div>
                      <div class="col-md-4 column"></div>
                    </div>
                  </div>
                </div>
                <div class="lyrow ui-draggable">
                  <a href="#close" class="remove label label-danger">
                    <i class="glyphicon-remove glyphicon"></i>
                    删除
                  </a>
                  <span class="drag label label-default">
                  <i class="glyphicon glyphicon-move"></i>
                  拖动
                </span>
                  <div class="preview">
                    4 4 4
                  </div>
                  <div class="view">
                    <div class="row clearfix">
                      <div class="col-md-4 column"></div>
                      <div class="col-md-4 column"></div>
                      <div class="col-md-4 column"></div>
                    </div>
                  </div>
                </div>
                <div class="lyrow ui-draggable">
                  <a href="#close" class="remove label label-danger">
                    <i class="glyphicon-remove glyphicon"></i>
                    删除
                  </a>
                  <span class="drag label label-default">
								<i class="glyphicon glyphicon-move"></i>
								拖动
							</span>

                  <div class="preview">
                    2 6 4
                  </div>
                  <div class="view">
                    <div class="row clearfix">
                      <div class="col-md-2 column"></div>
                      <div class="col-md-6 column"></div>
                      <div class="col-md-4 column"></div>
                    </div>
                  </div>
                </div>
              </li>
            </ul>
            <ul class="nav nav-list accordion-group">
              <li class="nav-header">
                <i class="glyphicon glyphicon-plus"></i>
                基本CSS
                <div class="pull-right popover-info">
                  <i class="glyphicon glyphicon-question-sign "></i>

                  <div class="popover fade right">
                    <div class="arrow"></div>
                    <h3 class="popover-title">帮助</h3>

                    <div class="popover-content">
                      xxxxx
                    </div>
                  </div>
                </div>
              </li>
              <li id="elmBase" class="boxes">
                <div class="box box-element ui-draggable">
                  <a href="#close" class="remove label label-danger">
                    <i class="glyphicon glyphicon-remove"></i>
                    删除
                  </a>
                  <span class="drag label label-default">
								<i class="glyphicon glyphicon-move"></i>
								拖动
							</span>
                  <span class="configuration">
								<span class="btn-group btn-group-xs">
									<a class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#">
                                      对齐
                                      <span class="caret"></span>
                                    </a>
									<ul class="dropdown-menu">
                                      <li class="active">
                                        <a href="#" rel="">默认</a>
                                      </li>
                                      <li class="">
                                        <a href="#" rel="text-left">靠左</a>
                                      </li>
                                      <li class="">
                                        <a href="#" rel="text-center">居中</a>
                                      </li>
                                      <li class="">
                                        <a href="#" rel="text-right">靠右</a>
                                      </li>
                                    </ul>
								</span>
								<span class="btn-group btn-group-xs">
									<a class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#">
                                      标记
                                      <span class="caret"></span>
                                    </a>
									<ul class="dropdown-menu">
                                      <li class="active">
                                        <a href="#" rel="">默认</a>
                                      </li>
                                      <li class="">
                                        <a href="#" rel="muted">禁用</a>
                                      </li>
                                      <li class="">
                                        <a href="#" rel="text-warning">警告</a>
                                      </li>
                                      <li class="">
                                        <a href="#" rel="text-error">错误</a>
                                      </li>
                                      <li class="">
                                        <a href="#" rel="text-info">提示</a>
                                      </li>
                                      <li class="">
                                        <a href="#" rel="text-success">成功</a>
                                      </li>
                                    </ul>
								</span>
							</span>

                  <div class="preview">标题栏</div>
                  <div class="view">
                    <h3 contenteditable="true">h3. 这是一套可视化布局系统.</h3>
                  </div>
                </div>
              </li>
            </ul>
            <ul class="nav nav-list accordion-group">
              <li class="nav-header">
                <i class="glyphicon glyphicon-plus"></i>
                工具组件
                <div class="pull-right popover-info">
                  <i class="glyphicon glyphicon-question-sign "></i>

                  <div class="popover fade right">
                    <div class="arrow"></div>
                    <h3 class="popover-title">帮助</h3>

                    <div class="popover-content">
                      {{$t("message.title")}}
                    </div>
                  </div>
                </div>
              </li>
              <li id="elmComponents" class="boxes">
                <div class="box box-element ui-draggable">
                  <a href="#close" class="remove label label-danger">
                    <i class="glyphicon glyphicon-remove"></i>
                    删除
                  </a>
                  <span class="drag label label-default">
								<i class="glyphicon glyphicon-move"></i>
								拖动
							</span>
                  <span class="configuration">
								  <span id="vertical" href="javascript:void(0)">竖向</span>
							</span>

                  <div class="preview">按钮组</div>
                  <div class="view">
                    <div class="btn-group">
                      <button class="btn btn-default" type="button">
                        <i class="glyphicon glyphicon-align-left"></i>
                        左
                      </button>
                      <button class="btn btn-default" type="button">
                        <i class="glyphicon glyphicon-align-center"></i>
                        中
                      </button>
                      <button class="btn btn-default" type="button">
                        <i class="glyphicon glyphicon-align-right"></i>
                        右
                      </button>
                      <button class="btn btn-default" type="button">
                        <i class="glyphicon glyphicon-align-justify"></i>
                        全
                      </button>
                    </div>
                  </div>
                </div>
              </li>
            </ul>
            <ul class="nav nav-list accordion-group">
              <li class="nav-header">
                <i class="glyphicon glyphicon-plus"></i>
                JavaScript
                <div class="pull-right popover-info">
                  <i class="glyphicon glyphicon-question-sign "></i>

                  <div class="popover fade right">
                    <div class="arrow"></div>
                    <h3 class="popover-title">帮助</h3>

                    <div class="popover-content">
                      xxxxx
                    </div>
                  </div>
                </div>
              </li>
              <li id="elmJS" class="boxes mute">
                <div class="box box-element ui-draggable" renderstate="C">
                  <a href="#close" class="remove label label-danger">
                    <i class="glyphicon glyphicon-remove"></i>
                    删除
                  </a>
                  <span class="drag label label-default">
								<i class="glyphicon glyphicon-move"></i>
								拖动
							</span>
                  <div class="preview">导航栏</div>
                  <div class="view">
                    <div class="cus_component" type="barchart">惺惺惜惺惺</div>
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </div>
        <!--/span-->
        <div style="min-height: 754px;" class="demo ui-sortable"/>
        <!--/span-->
        <div id="download-layout">
          下载页面内容
        </div>
      </div>
      <!--/row-->
    </div>
    <!--/.fluid-container-->

    <div
      id="downloadModal"
      style="display: none;"
      class="modal fade"
      tabindex="-1"
      role="dialog"
      aria-labelledby="downloadModalLabel"
      aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title">下载</h4>
          </div>
          <div class="modal-body">

            <div id="download-logged" class="">
              <div class="alert alert-info">已在下面生成干净的HTML, 可以复制粘贴代码到你的body内
              </div>
              <p>
                <textarea/>
              </p>
            </div>

          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          </div>
        </div>
        <!-- /.modal-content -->
      </div>
    </div>
    <!--设置:closable="false" 取消差按钮-->
    <Drawer
      :mask-style="maskstyle"
      :styles="styles"
      v-model="openTheme"
      title="Create"
      width="500"
    >
      <component :is="currentView" :component-obj="componentObj"/>
    </Drawer>
  </div>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import { init, downloadLayoutSrc, clearDemo } from '../../utils/scripts'

export default {
  data() {
    // 普通属性国际化切换无效果
    return {
      chart: '<v-barchart></v-barchart>',
      chart2: '<div v-world:wbs17022.hehe.haha></div>',
      currentView: '',
      openTheme: false,
      maskstyle: {
        background: 'transparent'
      },
      styles: {
        height: 'calc(100% - 55px)',
        overflow: 'auto',
        paddingBottom: '53px',
        position: 'static'
      },
      componentObj: {}
    }
  },
  computed: {
    // js中引用国际化放在计算属性中
    nike() {
      return this.$t('brands.nike')
    }
  },
  mounted: function() {
    // 弹出属性配置栏
    this.$bus.$on('on-attraConfig', (componentObj, conifgComponentName) => {
      this.currentView = ''
      this.currentView = conifgComponentName
      this.componentObj = componentObj
      console.log(componentObj._uid)
      this.openTheme = true
    })
    // 保存页面
    this.$bus.$on('on-downloadPage', () => {
      console.log('on-downloadPage')
      downloadLayoutSrc()
    })
    // 加载页面
    this.$bus.$on('on-loadPage', () => {
      console.log('on-loadPage')
      this.addPage()
    })
    // 清空编辑区域内容
    this.$bus.$on('on-cleanContent', () => {
      console.log('on-cleanContent')
      clearDemo()
    })
    init(this)
    const self = this
    $('.demo, .demo .column').sortable({
      connectWith: '.demo', // 只能放在.demo区域内，若布局嵌套设置为.column
      opacity: 0.35,
      handle: '.drag',
      accept: '.demo'
    })
    $('.sidebar-nav .lyrow').draggable({
      connectToSortable: '.demo',
      helper: 'clone',
      handle: '.drag',
      drag: function(e, t) {
        t.helper.width(400)
      },
      stop: function(event, ui) {
        // 设置嵌套
        $('.demo .column').sortable({
          opacity: 0.35,
          connectWith: '.column',
          stop: function(event, ui) {
            const curModuleObj = ui.item
            const state = curModuleObj.attr('renderstate')
            // 只处理新未进行渲染的新组件
            if (state === 'C') {
              const str = '' + self.$uuid.create()
              const reg = new RegExp('-', 'g')
              const newstr = str.replace(reg, '')
              // 创建临时组件id
              const tmpComponentId = 'C' + newstr
              // 获取组件类型
              const moduleType = curModuleObj.find('.cus_component').attr('type')
              curModuleObj.find('.cus_component').attr('id', tmpComponentId)
              self.$nextTick(function() {
                const strs = `<${moduleType} ref="${tmpComponentId}"></${moduleType}>`
                const MyComponent = Vue.extend({
                  mounted: function() {
                    if (this.$refs[tmpComponentId]) {
                      // 向windows注册组件对象
                      const componentUid = 'C' + this.$refs[tmpComponentId]._uid
                      // window[cusComponentId] = this.$refs[cusComponentId]
                      window[componentUid] = this.$refs[tmpComponentId]
                    }
                  },
                  updated: function() {
                    // 异步加载组件，初次触发updated事件
                    if (this.$refs[tmpComponentId]) {
                      const componentUid = 'C' + this.$refs[tmpComponentId]._uid
                      // window[cusComponentId] = this.$refs[cusComponentId];
                      window[componentUid] = this.$refs[tmpComponentId]
                    }
                  },
                  template: strs
                })
                new MyComponent().$mount('#' + tmpComponentId)
                // 挂载后渲染状态设置为O 旧组件状态
                curModuleObj.attr('renderstate', 'O')
              })
            }
          }
        })
      }
    })
    $('.sidebar-nav .box').draggable({
      connectToSortable: '.column',
      helper: 'clone',
      handle: '.drag',
      drag: function(e, t) {
        t.helper.width(400)
      }
    })
  },
  methods: {
    addPage() {
      // 先清空再加载
      $('.demo').children().remove()
      $('.demo').html('<div id="mount-point"></div>')
      // 模拟从后台读取页面
      const strs = '<div renderstate="O" class="lyrow ui-draggable" style="display: block;"><a href="javascript:void(0)" class="remove label label-danger"><i class="glyphicon-remove glyphicon"></i>删除</a> <span class="drag label label-default"><i class="glyphicon glyphicon-move"></i>拖动</span><div class="preview"><input value="12" type="text" class="form-control"></div><div class="view"><div class="row clearfix"><div class="col-md-12 column"><barchart></barchart></div></div></div></div>'
      // 动态挂载页面
      var MyComponent = Vue.extend({
        template: strs
      })
      new MyComponent().$mount('#mount-point')
    }
  }
}
</script>
<style type="text/scss" rel="stylesheet/scss" lang="scss">
  tabbar-wrapper {
    position: absolute;
    width: 100%;
    bottom: 0;
    left: 0;
  }

  /*修改编辑器左侧样式*/
  .sidebar-nav {
    width: 240px;
    height: 100%;
    top: 0px;
  }
</style>
