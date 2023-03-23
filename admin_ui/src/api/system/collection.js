import request from '@/utils/request'

// 查询题集内容、课程内容等资源数据列表
export function listCollection(query) {
  return request({
    url: '/system/collection/list',
    method: 'get',
    params: query
  })
}

// 查询题集内容、课程内容等资源数据详细
export function getCollection(id) {
  return request({
    url: '/system/collection/' + id,
    method: 'get'
  })
}

// 新增题集内容、课程内容等资源数据
export function addCollection(data) {
  return request({
    url: '/system/collection',
    method: 'post',
    data: data
  })
}

// 修改题集内容、课程内容等资源数据
export function updateCollection(data) {
  return request({
    url: '/system/collection',
    method: 'put',
    data: data
  })
}

// 删除题集内容、课程内容等资源数据
export function delCollection(id) {
  return request({
    url: '/system/collection/' + id,
    method: 'delete'
  })
}
