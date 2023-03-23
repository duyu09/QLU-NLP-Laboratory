import request from '@/utils/request'

// 查询人物志数据列表
export function listCharacter(query) {
  return request({
    url: '/system/character/list',
    method: 'get',
    params: query
  })
}

// 查询人物志数据详细
export function getCharacter(id) {
  return request({
    url: '/system/character/' + id,
    method: 'get'
  })
}

// 新增人物志数据
export function addCharacter(data) {
  return request({
    url: '/system/character',
    method: 'post',
    data: data
  })
}

// 修改人物志数据
export function updateCharacter(data) {
  return request({
    url: '/system/character',
    method: 'put',
    data: data
  })
}

// 删除人物志数据
export function delCharacter(id) {
  return request({
    url: '/system/character/' + id,
    method: 'delete'
  })
}
