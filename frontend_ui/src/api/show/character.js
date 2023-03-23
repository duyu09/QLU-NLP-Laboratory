import request from "@/utils/request";

// 查询人物志管理列表
export function listCharacter(dictType) {
  return request({
    url: "/show/character/list/" + dictType,
    headers: {
      isToken: false,
    },
    method: "get",
  });
}

// 查询人物志管理详细
export function getCharacter(id) {
  return request({
    url: "/show/character/" + id,
    headers: {
      isToken: false,
    },
    method: "get",
  });
}
