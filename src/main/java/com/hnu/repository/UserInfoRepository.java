package com.hnu.repository;

import com.hnu.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository {

    List<UserInfo> searchStores(String keyword,int page_items_count,int current_position);

    UserInfo selectUserInfo(long id);

}
