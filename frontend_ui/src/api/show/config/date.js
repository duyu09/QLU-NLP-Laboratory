import request from "@/utils/request";

// 根据字典类型查询字典数据信息
export function getDicts(dictType) {
  return request({
    url: "/show/config/type/" + dictType,
    headers: {
      isToken: false,
    },
    method: "get",
  });
}
