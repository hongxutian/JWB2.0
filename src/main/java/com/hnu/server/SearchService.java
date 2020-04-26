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
                UserInfo userInfo = userInfoRepository.selectUserInfo(demand.getuIdId());
                JSONObject object = (JSONObject) JSON.toJSON(demand);
                object.put("s_lon",demand.getsLon());
                object.put("s_lat",demand.getsLat());
                object.put("s_nation",demand.getsNation());
                object.put("s_city",demand.getsCity());
                object.put("s_province",demand.getsProvince());
                object.put("s_street",demand.getsStreet());
                object.put("s_street_number",demand.getsStreetNumber());
                object.put("s_content",demand.getsContent());
                object.put("s_type",demand.getsType());
                object.put("s_range",demand.getsRange());
                object.put("s_aging",demand.getsAging());
                object.put("s_subtime",demand.getsSubtime());
                object.put("store_name",demand.getStoreName());
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
