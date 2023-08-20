import request from '@/utils/request'

// 查询成员编辑器列表
export function listModule(query) {
  return request({
    url: '/nlp/module/list',
    method: 'get',
    params: query
  })
}

// 查询成员编辑器详细
export function getModule(id) {
  return request({
    url: '/nlp/module/' + id,
    method: 'get'
  })
}

// 新增成员编辑器
export function addModule(data) {
  return request({
    url: '/nlp/module',
    method: 'post',
    data: data
  })
}

// 修改成员编辑器
export function updateModule(data) {
  return request({
    url: '/nlp/module',
    method: 'put',
    data: data
  })
}

// 删除成员编辑器
export function delModule(id) {
  return request({
    url: '/nlp/module/' + id,
    method: 'delete'
  })
}
