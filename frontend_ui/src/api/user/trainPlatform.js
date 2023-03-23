import request from '@/utils/request'

// 查询平台账号绑定数据列表
export function listTrainPlatform(query) {
  return request({
    url: '/frontendWeb/trainPlatform/list',
    method: 'get',
    params: query
  })
}

// 查询平台账号绑定数据详细
export function getTrainPlatform(userId) {
  return request({
    url: '/frontendWeb/trainPlatform/' + userId,
    method: 'get'
  })
}

// 新增平台账号绑定数据
export function addTrainPlatform(data) {
  return request({
    url: '/frontendWeb/trainPlatform',
    method: 'post',
    data: data
  })
}

// 修改平台账号绑定数据
export function updateTrainPlatform(data) {
  return request({
    url: '/frontendWeb/trainPlatform',
    method: 'put',
    data: data
  })
}
