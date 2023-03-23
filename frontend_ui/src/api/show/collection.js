import request from "@/utils/request";

// 查询题集资源管理列表
export function listCollection(dictType, remark) {
  return request({
    url: "/show/collection/list/" + dictType + "/" + remark,
    headers: {
      isToken: false,
    },
    method: "get",
  });
}

// 查询题集资源管理详细
export function getCollection(id) {
  return request({
    url: "/show/collection/" + id,
    headers: {
      isToken: false,
    },
    method: "get",
  });
}
