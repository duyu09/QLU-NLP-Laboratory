import request from '@/utils/request'

// 查询团队掠影 标题 (title)列表
export function listTeamOverviewTitle(query) {
  return request({
    url: '/nlp/admission/teamOverviewTitle/list',
    method: 'get',
    params: query
  })
}

// 查询团队掠影 标题 (title)详细
export function getTeamOverviewTitle(id) {
  return request({
    url: '/nlp/admission/teamOverviewTitle/' + id,
    method: 'get'
  })
}

// 新增团队掠影 标题 (title)
export function addTeamOverviewTitle(data) {
  return request({
    url: '/nlp/admission/teamOverviewTitle',
    method: 'post',
    data: data
  })
}

// 修改团队掠影 标题 (title)
export function updateTeamOverviewTitle(data) {
  return request({
    url: '/nlp/admission/teamOverviewTitle',
    method: 'put',
    data: data
  })
}

// 删除团队掠影 标题 (title)
export function delTeamOverviewTitle(id) {
  return request({
    url: '/nlp/admission/teamOverviewTitle/' + id,
    method: 'delete'
  })
}
