import request from '@/utils/request'

// 查询研究方向管理列表
export function listDirection(query) {
  return request({
    url: '/nlp/direction/list',
    method: 'get',
    params: query
  })
}

// 查询研究方向管理详细
export function getDirection(id) {
  return request({
    url: '/nlp/direction/' + id,
    method: 'get'
  })
}

// 新增研究方向管理
export function addDirection(data) {
  return request({
    url: '/nlp/direction',
    method: 'post',
    data: data
  })
}

// 修改研究方向管理
export function updateDirection(data) {
  return request({
    url: '/nlp/direction',
    method: 'put',
    data: data
  })
}

// 删除研究方向管理
export function delDirection(id) {
  return request({
    url: '/nlp/direction/' + id,
    method: 'delete'
  })
}
