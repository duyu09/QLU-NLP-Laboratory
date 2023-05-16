import request from '@/utils/request'

// 查询联系我们列表
export function listFrontendAbout(query) {
  return request({
    url: '/nlp/frontend/about/list',
    method: 'get',
    params: query
  })
}

// 查询联系我们详细
export function getFrontendAbout(id) {
  return request({
    url: '/nlp/frontend/about/' + id,
    method: 'get'
  })
}

// 新增联系我们
export function addFrontendAbout(data) {
  return request({
    url: '/nlp/frontend/about',
    method: 'post',
    data: data
  })
}

// 修改联系我们
export function updateFrontendAbout(data) {
  return request({
    url: '/nlp/frontend/about',
    method: 'put',
    data: data
  })
}

// 删除联系我们
export function delFrontendAbout(id) {
  return request({
    url: '/nlp/frontend/about/' + id,
    method: 'delete'
  })
}


// 查询type
export function getByType(type){
  return request({
    url: '/nlp/frontend/about/byType/' + type,
    method: 'get'
  })
}


