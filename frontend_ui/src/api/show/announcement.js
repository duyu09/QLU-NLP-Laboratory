import request from "@/utils/request";

// 查询公告通知管理列表
export function listAnnouncement(dictType) {
  return request({
    url: "/show/announcement/list/" + dictType,
    headers: {
      isToken: false,
    },
    method: "get",
  });
}

// 查询公告通知管理详细
export function getAnnouncement(id) {
  return request({
    url: "/show/announcement/" + id,
    headers: {
      isToken: false,
    },
    method: "get",
  });
}
