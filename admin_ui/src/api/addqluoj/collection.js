import request from '@/utils/request'

// 查询题集资源管理列表
export function listCollection(query) {
  return request({
    url: '/addqluoj/collection/list',
    method: 'get',
    params: query
  })
}

// 查询题集资源管理详细
export function getCollection(id) {
  return request({
    url: '/addqluoj/collection/' + id,
    method: 'get'
  })
}

// 新增题集资源管理
export function addCollection(data) {
  return request({
    url: '/addqluoj/collection',
    method: 'post',
    data: data
  })
}

// 修改题集资源管理
export function updateCollection(data) {
  return request({
    url: '/addqluoj/collection',
    method: 'put',
    data: data
  })
}

// 删除题集资源管理
export function delCollection(id) {
  return request({
    url: '/addqluoj/collection/' + id,
    method: 'delete'
  })
}
