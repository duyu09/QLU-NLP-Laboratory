import request from '@/utils/request'

// 查询视频资源管理列表
export function listCourse(query) {
  return request({
    url: '/addqluoj/course/list',
    method: 'get',
    params: query
  })
}

// 查询视频资源管理详细
export function getCourse(id) {
  return request({
    url: '/addqluoj/course/' + id,
    method: 'get'
  })
}

// 新增视频资源管理
export function addCourse(data) {
  return request({
    url: '/addqluoj/course',
    method: 'post',
    data: data
  })
}

// 修改视频资源管理
export function updateCourse(data) {
  return request({
    url: '/addqluoj/course',
    method: 'put',
    data: data
  })
}

// 删除视频资源管理
export function delCourse(id) {
  return request({
    url: '/addqluoj/course/' + id,
    method: 'delete'
  })
}
