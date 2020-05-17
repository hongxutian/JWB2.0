package com.hnu.server;

import com.hnu.entity.Demand;
import com.hnu.entity.SearUserInforBean;
import com.hnu.entity.SearchBean;
import com.hnu.entity.user.UserInfo;
import com.hnu.repository.DemandRepository;
import com.hnu.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public List<SearchBean> searchStores(String keyword,int page_items_count,int current_position){
        try {
            keyword = "%"+keyword+"%";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            List<Demand> res = demandRepository.searchStores(keyword,page_items_count,current_position);
            List<SearchBean> r = new ArrayList<>();
            for(int i=0;i<res.size();i++){
                Demand demand = res.get(i);

                SearchBean searchBean = new SearchBean();
                SearUserInforBean userInfo = userInfoRepository.selectUserInfo(demand.getU_id_id());
                searchBean.setS_lon(demand.getS_lon());
                searchBean.setS_lat(demand.getS_lat());
                searchBean.setS_nation(demand.getS_nation());
                searchBean.setS_city(demand.getS_city());
                searchBean.setS_province(demand.getS_province());
                searchBean.setS_street(demand.getS_street());
                searchBean.setS_street_number(demand.getS_street_number());
                searchBean.setS_content(demand.getS_content());
                searchBean.setS_type(demand.getS_type());
                searchBean.setS_range(demand.getS_range());
                searchBean.setS_aging(demand.getS_aging());
                searchBean.setS_subtime(simpleDateFormat.format(demand.getS_subtime()));
                searchBean.setStore_name(demand.getStore_name());

                SearchBean.UIdBean uIdBean = new SearchBean.UIdBean();
                uIdBean.setId(userInfo.getId());
                uIdBean.setU_type(userInfo.getUType());
                uIdBean.setOpen_id(userInfo.getOpenId());
                uIdBean.setNick_name(userInfo.getNickName());
                uIdBean.setAvatar_url(userInfo.getAvatarUrl());
                uIdBean.setGender(userInfo.getGender());
                uIdBean.setStore_name(userInfo.getStoreName());
                uIdBean.setM_longitude(userInfo.getMLongitude());
                uIdBean.setM_latitude(userInfo.getMLatitude());
                uIdBean.setNation(userInfo.getNation());
                uIdBean.setCity(userInfo.getCity());
                uIdBean.setProvince(userInfo.getProvince());
                uIdBean.setDistrict(userInfo.getDistrict());
                uIdBean.setStreet(userInfo.getStreet());
                uIdBean.setStreet_number(userInfo.getStreetNumber());
                searchBean.setU_id(uIdBean);

                r.add(searchBean);

            }
            return r;
        }catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }

}
