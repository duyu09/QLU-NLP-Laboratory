import request from '@/utils/request'

// 查询人物志管理列表
export function listCharacter(query) {
  return request({
    url: '/addqluoj/character/list',
    method: 'get',
    params: query
  })
}

// 查询人物志管理详细
export function getCharacter(id) {
  return request({
    url: '/addqluoj/character/' + id,
    method: 'get'
  })
}

// 新增人物志管理
export function addCharacter(data) {
  return request({
    url: '/addqluoj/character',
    method: 'post',
    data: data
  })
}

// 修改人物志管理
export function updateCharacter(data) {
  return request({
    url: '/addqluoj/character',
    method: 'put',
    data: data
  })
}

// 删除人物志管理
export function delCharacter(id) {
  return request({
    url: '/addqluoj/character/' + id,
    method: 'delete'
  })
}
