import request from '@/utils/request'

export function getAllApplication(deptId) {
  const params = {
    deptId,
    page: 0,
    size: 9999
  }
  return request({
    url: 'api/application',
    method: 'get',
    params
  })
}

export function add(data) {
  return request({
    url: 'api/application',
    method: 'post',
    data
  })
}

export function del(id) {
  return request({
    url: 'api/application/' + id,
    method: 'delete'
  })
}

export function edit(data) {
  return request({
    url: 'api/application',
    method: 'put',
    data
  })
}
