import request from '@/utils/request'

// 查询视频资源数据列表
export function listCourse(query) {
  return request({
    url: '/system/course/list',
    method: 'get',
    params: query
  })
}

// 查询视频资源数据详细
export function getCourse(id) {
  return request({
    url: '/system/course/' + id,
    method: 'get'
  })
}

// 新增视频资源数据
export function addCourse(data) {
  return request({
    url: '/system/course',
    method: 'post',
    data: data
  })
}

// 修改视频资源数据
export function updateCourse(data) {
  return request({
    url: '/system/course',
    method: 'put',
    data: data
  })
}

// 删除视频资源数据
export function delCourse(id) {
  return request({
    url: '/system/course/' + id,
    method: 'delete'
  })
}
