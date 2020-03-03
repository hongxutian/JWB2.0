package com.hnu.server;

import com.hnu.entity.Demand;
import com.hnu.entity.Material;
import com.hnu.repository.DemandRepository;
import com.hnu.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PublishService {

    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    DemandRepository demandRepository;


    @Transactional(rollbackFor = Exception.class)
    public void savePublish(Demand demand, List<Material> resources){
        demandRepository.insertDemand(demand);
        for (int i=0;i<resources.size();i++){
            resources.get(i).setM_id_id(demand.getId());
        }
        materialRepository.insertMaterials(resources);
    }

}
