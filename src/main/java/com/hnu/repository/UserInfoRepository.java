package com.hnu.repository;

import com.hnu.entity.user.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository {

    UserInfo findByOpenId(String openId);

    void save(UserInfo userInfo);

    UserInfo selectUserInfo(@Param("id") long id);

}
