import request from '@/utils/request'

// 查询公告通知管理列表
export function listAnnouncement(query) {
  return request({
    url: '/addqluoj/announcement/list',
    method: 'get',
    params: query
  })
}

// 查询公告通知管理详细
export function getAnnouncement(id) {
  return request({
    url: '/addqluoj/announcement/' + id,
    method: 'get'
  })
}

// 新增公告通知管理
export function addAnnouncement(data) {
  return request({
    url: '/addqluoj/announcement',
    method: 'post',
    data: data
  })
}

// 修改公告通知管理
export function updateAnnouncement(data) {
  return request({
    url: '/addqluoj/announcement',
    method: 'put',
    data: data
  })
}

// 删除公告通知管理
export function delAnnouncement(id) {
  return request({
    url: '/addqluoj/announcement/' + id,
    method: 'delete'
  })
}
