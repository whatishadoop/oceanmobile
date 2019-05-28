import request from '@/utils/request'

/**
 * 获取树形数据结构
 * @param params
 */
export function getBusi(params) {
  return request({
    url: 'api/appBusiSolutionTree',
    method: 'get',
    params
  })
}

export function add(data) {
  return request({
    url: 'api/appBusiSolution',
    method: 'post',
    data
  })
}

export function del(id) {
  return request({
    url: 'api/appBusiSolution/' + id,
    method: 'delete'
  })
}

export function edit(data) {
  return request({
    url: 'api/appBusiSolution',
    method: 'put',
    data
  })
}
