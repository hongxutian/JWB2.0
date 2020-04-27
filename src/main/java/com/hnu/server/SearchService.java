package com.hnu.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hnu.entity.Demand;
import com.hnu.entity.user.UserInfo;
import com.hnu.repository.DemandRepository;
import com.hnu.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    DemandRepository demandRepository = null;

    @Autowired
    UserInfoRepository userInfoRepository = null;

    /**
     * 查询商店的信息
     * @param keyword 查询的关键字
     * @param page_items_count 最大数量
     * @param current_position 当前的位置
     * @return
     */
    public String searchStores(String keyword,int page_items_count,int current_position){
        try {
            keyword = "%"+keyword+"%";
            List<Demand> res = demandRepository.searchStores(keyword,page_items_count,current_position);
            JSONArray array = new JSONArray();
            for(int i=0;i<res.size();i++){
                Demand demand = res.get(i);
                UserInfo userInfo = userInfoRepository.selectUserInfo(demand.getU_id_id());
                JSONObject object = (JSONObject) JSON.toJSON(demand);
                object.put("s_lon",demand.getS_lon());
                object.put("s_lat",demand.getS_lat());
                object.put("s_nation",demand.getS_nation());
                object.put("s_city",demand.getS_city());
                object.put("s_province",demand.getS_province());
                object.put("s_street",demand.getS_street());
                object.put("s_street_number",demand.getS_street_number());
                object.put("s_content",demand.getS_content());
                object.put("s_type",demand.getS_type());
                object.put("s_range",demand.getS_range());
                object.put("s_aging",demand.getS_aging());
                object.put("s_subtime",demand.getS_subtime());
                object.put("store_name",demand.getStore_name());
                JSONObject child = new JSONObject();
                child.put("u_type",userInfo.getU_type());
                child.put("open_id",userInfo.getOpen_id());
                child.put("nick_name",userInfo.getNick_name());
                child.put("avatar_url",userInfo.getAvatar_url());
                child.put("gender",userInfo.getGender());
                child.put("store_name",userInfo.getStore_name());
                child.put("m_longitude",userInfo.getM_longitude());
                child.put("m_latitude",userInfo.getM_latitude());
                child.put("nation",userInfo.getNation());
                child.put("city",userInfo.getCity());
                child.put("province",userInfo.getProvince());
                child.put("district",userInfo.getDistrict());
                child.put("street",userInfo.getStreet());
                child.put("street_number",userInfo.getStreet_number());
                object.put("u_id", child);
                array.add(object);
            }
            return array.toJSONString();
        }catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }

}
