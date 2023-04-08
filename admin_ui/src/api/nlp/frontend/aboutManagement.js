import request from '@/utils/request'

// 查询联系我们(管理)列表
export function listFrontendAboutManagement(query) {
  return request({
    url: '/nlp/frontend/aboutManagement/list',
    method: 'get',
    params: query
  })
}

// 查询联系我们(管理)详细
export function getFrontendAboutManagement(id) {
  return request({
    url: '/nlp/frontend/aboutManagement/' + id,
    method: 'get'
  })
}

// 新增联系我们(管理)
export function addFrontendAboutManagement(data) {
  return request({
    url: '/nlp/frontend/aboutManagement',
    method: 'post',
    data: data
  })
}

// 修改联系我们(管理)
export function updateFrontendAboutManagement(data) {
  return request({
    url: '/nlp/frontend/aboutManagement',
    method: 'put',
    data: data
  })
}

// 删除联系我们(管理)
export function delFrontendAboutManagement(id) {
  return request({
    url: '/nlp/frontend/aboutManagement/' + id,
    method: 'delete'
  })
}
