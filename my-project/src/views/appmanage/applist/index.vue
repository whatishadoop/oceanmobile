<template>
  <div class="app-container">
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="4" :lg="4" :xl="4">
        <div class="head-container">
          <el-input v-model="busiName" clearable placeholder="输入业务名称搜索" prefix-icon="el-icon-search" style="width: 100%;" class="filter-item" @input="getBusiNames"/>
        </div>
        <el-tree :data="busiNames" :props="defaultProps" :expand-on-click-node="false" default-expand-all @node-click="handleNodeClick"/>
      </el-col>
      <el-col :xs="24" :sm="24" :md="20" :lg="20" :xl="20">
        <eHeader :query="query" :dicts="dicts" :sup_this="sup_this"/>
        <!--表格渲染-->
        <el-table v-loading="loading" :data="data" size="small" style="width: 100%;">
          <el-table-column prop="name" label="名称"/>
          <el-table-column label="所属业务">
            <template slot-scope="scope">
              <div>{{ scope.row.busiName }}</div>
            </template>
          </el-table-column>
          <el-table-column prop="sort" label="排序">
            <template slot-scope="scope">
              {{ scope.row.sort }}
            </template>
          </el-table-column>
          <el-table-column label="状态" align="center">
            <template slot-scope="scope">
              <div v-for="item in dicts" :key="item.id">
                <el-tag v-if="scope.row.enabled.toString() === item.value" :type="scope.row.enabled ? '' : 'info'">{{ item.label }}</el-tag>
              </div>
            </template>
          </el-table-column>
          <el-table-column prop="createTime" label="创建日期">
            <template slot-scope="scope">
              <span>{{ parseTime(scope.row.createTime) }}</span>
            </template>
          </el-table-column>
          <el-table-column label="操作" width="150px" align="center">
            <template slot-scope="scope">
              <edit v-if="checkPermission(['ADMIN','APP_ALL','APP_EDIT'])" :dicts="dicts" :data="scope.row" :sup_this="sup_this"/>
              <el-popover
                v-if="checkPermission(['ADMIN','APP_ALL','APP_DELETE'])"
                :ref="scope.row.id"
                placement="top"
                width="180">
                <p>确定删除本条数据吗？</p>
                <div style="text-align: right; margin: 0">
                  <el-button size="mini" type="text" @click="$refs[scope.row.id].doClose()">取消</el-button>
                  <el-button :loading="delLoading" type="primary" size="mini" @click="subDelete(scope.row.id)">确定</el-button>
                </div>
                <el-button slot="reference" type="danger" icon="el-icon-delete" size="mini"/>
              </el-popover>
            </template>
          </el-table-column>
        </el-table>
        <!--分页组件-->
        <el-pagination
          :total="total"
          style="margin-top: 8px;"
          layout="total, prev, pager, next, sizes"
          @size-change="sizeChange"
          @current-change="pageChange"/>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import checkPermission from '@/utils/permission'
import initData from '@/mixins/initData'
import initDict from '@/mixins/initDict'
import { del } from '@/api/app'
import { parseTime } from '@/utils/index'
import { getBusi } from '@/api/appBusiSolution'
import eHeader from './module/header'
import edit from './module/edit'

export default {
  components: { eHeader, edit },
  mixins: [initData, initDict],
  data() {
    return {
      delLoading: false,
      sup_this: this,
      busiName: '',
      busiNames: [],
      busiNameId: null,
      defaultProps: {
        children: 'children',
        label: 'name'
      }
    }
  },
  created() {
    this.getBusiNames()
    this.$nextTick(() => {
      this.init()
      // 加载数据字典
      this.getDict('job_status')
    })
  },
  methods: {
    parseTime,
    checkPermission,
    beforeInit() {
      this.url = 'api/application'
      const sort = 'id,asc'
      this.params = { page: this.page, size: this.size, sort: sort, busiNameId: this.busiNameId }
      const query = this.query
      const value = query.value
      const enabled = query.enabled
      if (value) {
        this.params['name'] = value
      }
      if (enabled !== '' && enabled !== null) {
        this.params['enabled'] = enabled
      }
      return true
    },
    subDelete(id) {
      this.delLoading = true
      del(id).then(res => {
        this.delLoading = false
        this.$refs[id].doClose()
        this.init()
        this.$notify({
          title: '删除成功',
          type: 'success',
          duration: 2500
        })
      }).catch(err => {
        this.delLoading = false
        this.$refs[id].doClose()
        console.log(err.response.data.message)
      })
    },
    getBusiNames() {
      const sort = 'id,desc'
      const params = { sort: sort }
      if (this.busiName) { params['name'] = this.busiName }
      getBusi(params).then(res => {
        this.busiNames = res.content
      })
    },
    handleNodeClick(data) {
      if (data.pid === 0) {
        this.busiNameId = null
      } else {
        this.busiNameId = data.id
      }
      this.init()
    }
  }
}
</script>
<style scoped>

</style>
