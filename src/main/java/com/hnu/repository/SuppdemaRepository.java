package com.hnu.repository;

import com.hnu.entity.Suppdema;
import com.hnu.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SuppdemaRepository {

    void insetSuppdema(Suppdema suppdema);

    List<Suppdema> searchStores(String keyword, int page_items_count, int current_position);

}
