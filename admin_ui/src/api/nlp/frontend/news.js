import request from '@/utils/request'

// 查询新闻动态管理列表
export function listNlpFrontendNews(query) {
  return request({
    url: '/nlp/frontend/news/list',
    method: 'get',
    params: query
  })
}

// 查询新闻动态管理详细
export function getNlpFrontendNews(id) {
  return request({
    url: '/nlp/frontend/news/' + id,
    method: 'get'
  })
}

// 新增新闻动态管理
export function addNlpFrontendNews(data) {
  return request({
    url: '/nlp/frontend/news',
    method: 'post',
    data: data
  })
}

// 修改新闻动态管理
export function updateNlpFrontendNews(data) {
  return request({
    url: '/nlp/frontend/news',
    method: 'put',
    data: data
  })
}

// 删除新闻动态管理
export function delNlpFrontendNews(id) {
  return request({
    url: '/nlp/frontend/news/' + id,
    method: 'delete'
  })

}
