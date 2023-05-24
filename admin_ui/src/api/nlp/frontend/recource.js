import request from '@/utils/request'

// 查询学术资源列表
export function listRecource(query) {
  return request({
    url: '/nlp/frontend/recource/list',
    method: 'get',
    params: query
  })
}

// 查询学术资源详细
export function getRecource(id) {
  return request({
    url: '/nlp/frontend/recource/' + id,
    method: 'get'
  })
}

// 新增学术资源
export function addRecource(data) {
  return request({
    url: '/nlp/frontend/recource',
    method: 'post',
    data: data
  })
}

// 修改学术资源
export function updateRecource(data) {
  return request({
    url: '/nlp/frontend/recource',
    method: 'put',
    data: data
  })
}

// 删除学术资源
export function delRecource(id) {
  return request({
    url: '/nlp/frontend/recource/' + id,
    method: 'delete'
  })
}
