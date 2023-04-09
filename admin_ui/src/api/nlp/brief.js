import request from '@/utils/request'

// 查询简介管理列表
export function listBrief(query) {
  return request({
    url: '/nlp/brief/list',
    method: 'get',
    params: query
  })
}

// 查询简介管理详细
export function getBrief(id) {
  return request({
    url: '/nlp/brief/' + id,
    method: 'get'
  })
}

// 新增简介管理
export function addBrief(data) {
  return request({
    url: '/nlp/brief',
    method: 'post',
    data: data
  })
}

// 修改简介管理
export function updateBrief(data) {
  return request({
    url: '/nlp/brief',
    method: 'put',
    data: data
  })
}

// 删除简介管理
export function delBrief(id) {
  return request({
    url: '/nlp/brief/' + id,
    method: 'delete'
  })
}
