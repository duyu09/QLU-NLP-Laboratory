import request from '@/utils/request'

// 查询学生 数据列表
export function listAdmissionStudent(query) {
  return request({
    url: '/nlp/admission/admissionStudent/list',
    method: 'get',
    params: query
  })
}

// 查询学生 数据详细
export function getAdmissionStudent(id) {
  return request({
    url: '/nlp/admission/admissionStudent/' + id,
    method: 'get'
  })
}

// 新增学生 数据
export function addAdmissionStudent(data) {
  return request({
    url: '/nlp/admission/admissionStudent',
    method: 'post',
    data: data
  })
}

// 修改学生 数据
export function updateAdmissionStudent(data) {
  return request({
    url: '/nlp/admission/admissionStudent',
    method: 'put',
    data: data
  })
}

// 删除学生 数据
export function delAdmissionStudent(id) {
  return request({
    url: '/nlp/admission/admissionStudent/' + id,
    method: 'delete'
  })
}
