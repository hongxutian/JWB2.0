package com.hnu.repository;

import com.hnu.entity.Resource;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface ResourceRepository {

    void insertResources(List<Resource> resources);

}
