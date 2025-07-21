import { request } from "./request";

export function getDetailData(iid) {
  return request({
    url:'/detail',
    method: 'get',
    params : {
      iid
    }
  })
}