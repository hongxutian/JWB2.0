package com.hnu.server;

import com.hnu.entity.Resource;
import com.hnu.entity.Suppdema;
import com.hnu.repository.ResourceRepository;
import com.hnu.repository.SuppdemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PublishService {

    @Autowired
    ResourceRepository resourceRepository;

    @Autowired
    SuppdemaRepository suppdemaRepository;


    @Transactional(rollbackFor = Exception.class)
    public void savePublish(Suppdema suppdema, List<Resource> resources){
        suppdemaRepository.insetSuppdema(suppdema);
        for (int i=0;i<resources.size();i++){
            resources.get(i).setMIdId(suppdema.getId());
        }
        resourceRepository.insertResources(resources);
    }

}
