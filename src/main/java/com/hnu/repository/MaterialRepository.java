package com.hnu.repository;

import com.hnu.entity.Material;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository {

    void insertMaterials(List<Material> materials);
    List<Material> findMaterialById(int id);

}
