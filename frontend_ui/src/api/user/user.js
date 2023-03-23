import request from "@/utils/request";

// 退出方法
export function logout() {
  return request({
    url: "/web/logout",
    method: "post",
  });
}

// 获取用户详细信息
export function getInfo() {
  return request({
    url: "/web/getInfo",
    method: "get",
  });
}
