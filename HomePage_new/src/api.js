import axios from 'axios'
const baseURL=import.meta.env.VITE_BASE_URL
export
{
    getRotoGraphHttp,
}

function getRotoGraphHttp(){
    return axios.get(baseURL+'/show/nlp/carousel/list')
}
