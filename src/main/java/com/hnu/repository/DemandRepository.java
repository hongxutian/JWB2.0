package com.hnu.repository;

import com.hnu.entity.Demand;
import com.hnu.entity.Limit;

import java.util.List;

public interface DemandRepository {

    List<Demand> findByRange(Limit limit);
}
