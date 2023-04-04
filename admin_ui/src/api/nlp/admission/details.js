import request from '@/utils/request'

// 查询招生详情 培养计划 招聘详情 数据列表
export function listDetails(query) {
  return request({
    url: '/nlp/admission/details/list',
    method: 'get',
    params: query
  })
}

// 查询招生详情 培养计划 招聘详情 数据详细
export function getDetails(id) {
  return request({
    url: '/nlp/admission/details/' + id,
    method: 'get'
  })
}

// 新增招生详情 培养计划 招聘详情 数据
export function addDetails(data) {
  return request({
    url: '/nlp/admission/details',
    method: 'post',
    data: data
  })
}

// 修改招生详情 培养计划 招聘详情 数据
export function updateDetails(data) {
  return request({
    url: '/nlp/admission/details',
    method: 'put',
    data: data
  })
}

// 删除招生详情 培养计划 招聘详情 数据
export function delDetails(id) {
  return request({
    url: '/nlp/admission/details/' + id,
    method: 'delete'
  })
}
