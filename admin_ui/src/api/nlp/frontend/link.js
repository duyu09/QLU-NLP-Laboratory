import request from '@/utils/request'

// 查询友情链接列表
export function listFrontendLink(query) {
  return request({
    url: 'nlp/frontend/link/list',
    method: 'get',
    params: query
  })
}

// 查询友情链接详细
export function getFrontendLink(id) {
  return request({
    url: 'nlp/frontend/link/' + id,
    method: 'get'
  })
}

// 新增友情链接
export function addFrontendLink(data) {
  return request({
    url: 'nlp/frontend/link',
    method: 'post',
    data: data
  })
}

// 修改友情链接
export function updateFrontendLink(data) {
  return request({
    url: 'nlp/frontend/link',
    method: 'put',
    data: data
  })
}

// 删除友情链接
export function delFrontendLink(id) {
  return request({
    url: 'nlp/frontend/link/' + id,
    method: 'delete'
  })
}
