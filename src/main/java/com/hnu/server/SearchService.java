package com.hnu.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hnu.entity.Suppdema;
import com.hnu.entity.UserInfo;
import com.hnu.repository.SuppdemaRepository;
import com.hnu.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    SuppdemaRepository suppdemaRepository = null;

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
            List<Suppdema> res = suppdemaRepository.searchStores(keyword,page_items_count,current_position);
            JSONArray array = new JSONArray();
            for(int i=0;i<res.size();i++){
                Suppdema suppdema = res.get(i);
                UserInfo userInfo = userInfoRepository.selectUserInfo(suppdema.getUIdId());
                JSONObject object = new JSONObject();
                object.put("s_lon",suppdema.getSLon());
                object.put("s_lat",suppdema.getSLat());
                object.put("s_nation",suppdema.getSNation());
                object.put("s_city",suppdema.getSCity());
                object.put("s_province",suppdema.getSProvince());
                object.put("s_street",suppdema.getSStreet());
                object.put("s_street_number",suppdema.getSStreetNumber());
                object.put("s_content",suppdema.getSContent());
                object.put("s_type",suppdema.getSType());
                object.put("s_range",suppdema.getSRange());
                object.put("s_aging",suppdema.getSAging());
                object.put("s_subtime",suppdema.getSSubtime());
                object.put("store_name",suppdema.getStoreName());
                object.put("u_id", JSON.toJSON(userInfo));
                array.add(object);
            }
            return array.toJSONString();
        }catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }

}
