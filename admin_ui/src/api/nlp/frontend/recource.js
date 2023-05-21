import request from '@/utils/request'

// 查询学术资源列表
export function listFrontendRecource(query) {
  return request({
    url: '/nlp/frontend/recource/list',
    method: 'get',
    params: query
  })
}

// 查询学术资源详细
export function getFrontendRecource(id) {
  return request({
    url: '/nlp/frontend/recource/' + id,
    method: 'get'
  })
}

// 新增学术资源
export function addFrontendRecource(data) {
  return request({
    url: '/nlp/frontend/recource',
    method: 'post',
    data: data
  })
}

// 修改学术资源
export function updateFrontendRecource(data) {
  return request({
    url: '/nlp/frontend/recource',
    method: 'put',
    data: data
  })
}

// 删除学术资源
export function delFrontendRecource(id) {
  return request({
    url: '/nlp/frontend/recource' + id,
    method: 'delete'
  })
}

// 查询type
export function getByType(type){
  return request({
    url: '/nlp/frontend/recource/byType/' + type,
    method: 'get'
  })
}
