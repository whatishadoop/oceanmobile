import request from '@/utils/request'

export function get() {
  return request({
    url: 'api/fileConfig',
    method: 'get'
  })
}

export function update(data) {
  return request({
    url: 'api/fileConfig',
    data,
    method: 'put'
  })
}

export function del(id) {
  return request({
    url: 'api/fileContent/' + id,
    method: 'delete'
  })
}

export function download(id) {
  return request({
    url: 'api/fileContent/download/' + id,
    method: 'get'
  })
}

export function sync() {
  return request({
    url: 'api/fileContent/synchronize',
    method: 'post'
  })
}

export function delAll(ids) {
  return request({
    url: 'api/fileContent/',
    method: 'delete',
    data: ids
  })
}
