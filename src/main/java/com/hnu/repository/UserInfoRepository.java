package com.hnu.repository;

import com.hnu.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoRepository {

    UserInfo findByOpenId(String openId);
    void save(UserInfo userInfo);

    UserInfo selectUserInfo(@Param("id") long id);

}
