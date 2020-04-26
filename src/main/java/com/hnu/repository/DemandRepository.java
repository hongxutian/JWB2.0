package com.hnu.repository;

import com.hnu.entity.Demand;
import com.hnu.entity.Limit;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandRepository {

    List<Demand> findByRange(Limit limit);

    void insertDemand(Demand demand);

    List<Demand> searchStores(@Param("keyword") String keyword,@Param("page_items_count") int page_items_count,@Param("current_position") int current_position);
}
