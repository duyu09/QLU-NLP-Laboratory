import request from '@/utils/request'

// 查询招生详情 培养计划 招聘详情 数据（管理）列表
export function listDetailsManagement(query) {
  return request({
    url: '/nlp/admission/detailsManagement/list',
    method: 'get',
    params: query
  })
}

// 查询招生详情 培养计划 招聘详情 数据（管理）详细
export function getDetailsManagement(id) {
  return request({
    url: '/nlp/admission/detailsManagement/' + id,
    method: 'get'
  })
}

// 新增招生详情 培养计划 招聘详情 数据（管理）
export function addDetailsManagement(data) {
  return request({
    url: '/nlp/admission/detailsManagement',
    method: 'post',
    data: data
  })
}

// 修改招生详情 培养计划 招聘详情 数据（管理）
export function updateDetailsManagement(data) {
  return request({
    url: '/nlp/admission/detailsManagement',
    method: 'put',
    data: data
  })
}

// 删除招生详情 培养计划 招聘详情 数据（管理）
export function delDetailsManagement(id) {
  return request({
    url: '/nlp/admission/detailsManagement/' + id,
    method: 'delete'
  })
}
