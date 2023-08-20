import request from '@/utils/request'

// 查询职称列表
export function listTeacher(query) {
  return request({
    url: '/nlp/teacher/list',
    method: 'get',
    params: query
  })
}

// 查询职称详细
export function getTeacher(id) {
  return request({
    url: '/nlp/teacher/' + id,
    method: 'get'
  })
}

// 查询职称详细
export function getTeacherUser() {
  return request({
    url: '/nlp/teacher/user',
    method: 'get'
  })
}

// 新增职称
export function addTeacher(data) {
  return request({
    url: '/nlp/teacher',
    method: 'post',
    data: data
  })
}

// 修改职称
export function updateTeacher(data) {
  return request({
    url: '/nlp/teacher',
    method: 'put',
    data: data
  })
}

// 修改职称
export function saveTeacher(data) {
  return request({
    url: '/nlp/teacher/save',
    method: 'put',
    data: data
  })
}

// 删除职称
export function delTeacher(id) {
  return request({
    url: '/nlp/teacher/' + id,
    method: 'delete'
  })
}
