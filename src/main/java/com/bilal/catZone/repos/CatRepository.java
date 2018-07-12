package com.bilal.catZone.repos;

import com.bilal.catZone.models.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat,Integer> {
    Cat findByCatName(String name);
    Cat findByOwnerOwnerName(String ownerName);
}
