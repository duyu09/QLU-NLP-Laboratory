import axios from 'axios'
const baseURL=import.meta.env.VITE_BASE_URL
export
{
    getRotoGraphHttp,getFriendLink,getConnectUs,getNews,getNewsDetail,getAcademicResource,getStudentCultivation,getStudentManage
}
//轮播图
function getRotoGraphHttp(){
    return axios.get(baseURL+'/show/nlp/carousel/list')
}
//友情链接
function getFriendLink() {
    return axios.get(baseURL+'/show/nlp/link/list')
}
//联系我们
function getConnectUs() {
    return axios.get(baseURL+'/show/nlp/about/list')
}
//新闻列表
function getNews() {
    return axios.get(baseURL+'/show/nlp/news/list')
    // return axios.get("src/news.json")
}
//新闻详情
function getNewsDetail(id){
    return axios.get(baseURL+'/show/nlp/news/'+id)
}
//学术资源
function getAcademicResource(){
    return axios.get(baseURL+'/show/nlp/resource/list')
}
//人才培养
function getStudentCultivation(){
    return axios.get(baseURL+'/show/nlp/details/list')
}
//学生管理
function getStudentManage(){
    return axios.get(baseURL+'/show/nlp/admissionStudent/list')
}
