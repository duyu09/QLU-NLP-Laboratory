import request from '@/utils/request'

// 查询招生详情数据列表
export function listAdmissionDetails(query) {
  return request({
    url: '/nlp/admission/admissionDetails/list',
    method: 'get',
    params: query
  })
}

// 查询招生详情数据详细
export function getAdmissionDetails(id) {
  return request({
    url: '/nlp/admission/admissionDetails/' + id,
    method: 'get'
  })
}

// 新增招生详情数据
export function addAdmissionDetails(data) {
  return request({
    url: '/nlp/admission/admissionDetails',
    method: 'post',
    data: data
  })
}

// 修改招生详情数据
export function updateAdmissionDetails(data) {
  return request({
    url: '/nlp/admission/admissionDetails',
    method: 'put',
    data: data
  })
}

// 删除招生详情数据
export function delAdmissionDetails(id) {
  return request({
    url: '/nlp/admission/admissionDetails/' + id,
    method: 'delete'
  })
}
