import request from '@/utils/request'

// 查询公告通知数据列表
export function listAnnouncement(query) {
  return request({
    url: '/system/announcement/list',
    method: 'get',
    params: query
  })
}

// 查询公告通知数据详细
export function getAnnouncement(id) {
  return request({
    url: '/system/announcement/' + id,
    method: 'get'
  })
}

// 新增公告通知数据
export function addAnnouncement(data) {
  return request({
    url: '/system/announcement',
    method: 'post',
    data: data
  })
}

// 修改公告通知数据
export function updateAnnouncement(data) {
  return request({
    url: '/system/announcement',
    method: 'put',
    data: data
  })
}

// 删除公告通知数据
export function delAnnouncement(id) {
  return request({
    url: '/system/announcement/' + id,
    method: 'delete'
  })
}
