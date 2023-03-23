import request from "@/utils/request";

// 查询视频资源管理列表
export function listCourse(dictType) {
  return request({
    url: "/show/course/list/" + dictType,
    headers: {
      isToken: false,
    },
    method: "get",
  });
}

// 查询视频资源管理详细
export function getCourse(id) {
  return request({
    url: "/show/course/" + id,
    headers: {
      isToken: false,
    },
    method: "get",
  });
}
