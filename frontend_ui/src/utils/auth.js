import Cookies from "js-cookie";

const TokenKey = "User-Token";

export function getToken() {
  return Cookies.get(TokenKey);
}

export function setToken(token) {
  return Cookies.set(TokenKey, token);
}

export function removeToken() {
  console.log("删除token");
  return Cookies.remove(TokenKey);
}
