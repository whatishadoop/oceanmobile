<template>
  <div :cache="cache" :cid="cid" ctype="barchart" obj="component">
    <div :id="chartid" :style="{width: '200px', height: '200px',border: '1px dashed #F00'}"></div>
    <div>组件ID: {{'C' + _uid}}</div>
    <button @click="test(id)">交互测试</button><br/>
    执行js: <textarea v-model="executejs"></textarea>
    <div>交互数据: {{data}}</div>
    <Button @click="attraConfigClick">编辑</Button>
    <Button @click="attraConfigClick02">编辑02</Button>
  </div>
</template>

<script>
export default {
  // 框架传入
  props: {
    id: {
      type: String,
      default: '0'
    }
  },
  data() {
    return {
      cid: 'C' + this._uid,
      msg: 'Welcome 222',
      chartid: this.$uuid.create().hex,
      cache: '',
      data: '000',
      executejs: ''
    }
  },
  mounted() {
    console.log(this._uid)
    this.drawLine()
    // console.log(this.$data.chartid);
    const newObj = {}
    newObj.msg = this.$data.msg
    newObj.chartid = this.$data.chartid
    this.$data.cache = JSON.stringify(newObj)
    // console.log(this.$data.cache);

    // 删除视图时，同时删除对应的vue组件实例
    this.$bus.$on('on-deleteComponent', cid => {
      if (cid === this.cid) {
        this.$destroy()
      }
    })
  },
  destroyed() {
    console.log('删除组件')
  },
  methods: {
    attraConfigClick() {
      this.$bus.$emit('on-attraConfig', this, 'barchartconfig')
    },
    attraConfigClick02() {
      this.$bus.$emit('on-attraConfig', this, 'barchartconfig02')
    },
    test(aaa) {
      // 测试用: window.C48.test2('GGG');
      var foo = window
      foo.eval(this.executejs)
    },
    test2(aaa) {
      // alert(this.id);
      this.data = aaa
    },
    drawLine() {
      // 基于准备好的dom，初始化echarts实例
      const myChart = this.$echarts.init(document.getElementById('' + this.$data.chartid))
      // 绘制图表
      myChart.setOption({
        title: { text: '在Vue中使用echarts' },
        tooltip: {},
        xAxis: {
          data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
        },
        yAxis: {},
        series: [{
          name: '销量',
          type: 'bar',
          data: [5, 20, 36, 10, 10, 20]
        }]
      })
    }
  }
}
</script>
<style type="text/scss" rel="stylesheet/scss" lang="scss" scoped>

</style>
