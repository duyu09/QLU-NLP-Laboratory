import request from '@/utils/request'

// 查询团队掠影 图片 (img)列表
export function listTeamOverviewImg(query) {
  return request({
    url: '/nlp/admission/teamOverviewImg/list',
    method: 'get',
    params: query
  })
}

// 查询团队掠影 图片 (img)详细
export function getTeamOverviewImg(id) {
  return request({
    url: '/nlp/admission/teamOverviewImg/' + id,
    method: 'get'
  })
}

// 新增团队掠影 图片 (img)
export function addTeamOverviewImg(data) {
  return request({
    url: '/nlp/admission/teamOverviewImg',
    method: 'post',
    data: data
  })
}

// 修改团队掠影 图片 (img)
export function updateTeamOverviewImg(data) {
  return request({
    url: '/nlp/admission/teamOverviewImg',
    method: 'put',
    data: data
  })
}

// 删除团队掠影 图片 (img)
export function delTeamOverviewImg(id) {
  return request({
    url: '/nlp/admission/teamOverviewImg/' + id,
    method: 'delete'
  })
}
