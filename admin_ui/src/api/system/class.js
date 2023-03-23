import request from '@/utils/request'

// 查询分类类别总列表
export function listClass(query) {
  return request({
    url: '/system/class/list',
    method: 'get',
    params: query
  })
}

// 查询分类类别总详细
export function getClass(id) {
  return request({
    url: '/system/class/' + id,
    method: 'get'
  })
}

// 新增分类类别总
export function addClass(data) {
  return request({
    url: '/system/class',
    method: 'post',
    data: data
  })
}

// 修改分类类别总
export function updateClass(data) {
  return request({
    url: '/system/class',
    method: 'put',
    data: data
  })
}

// 删除分类类别总
export function delClass(id) {
  return request({
    url: '/system/class/' + id,
    method: 'delete'
  })
}
