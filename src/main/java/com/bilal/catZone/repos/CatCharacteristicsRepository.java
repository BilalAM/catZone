package com.bilal.catZone.repos;

import com.bilal.catZone.models.CatCharacteristics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CatCharacteristicsRepository extends JpaRepository<CatCharacteristics,Integer> {
}
