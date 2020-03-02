package com.hnu.repository;

import com.hnu.entity.UserInfo;
public interface UserInfoRepository {

    UserInfo findByOpenId(String openId);
    void save(UserInfo userInfo);

}
