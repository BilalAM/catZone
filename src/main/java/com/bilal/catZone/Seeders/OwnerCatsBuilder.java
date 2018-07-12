package com.bilal.catZone.Seeders;

import com.bilal.catZone.models.Cat;
import com.bilal.catZone.models.Owner;
import com.bilal.catZone.repos.CatRepository;
import com.bilal.catZone.repos.OwnerRepository;
import com.bilal.catZone.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerCatsBuilder {


    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private CatRepository catRepository;

    public OwnerCatsBuilder builderOwnerCats(Owner owner , Cat... cats){
        owner.setCats(cats);
        ownerRepository.save(owner);
        return this;
    }
}
