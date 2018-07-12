package com.bilal.catZone.Seeders;

import com.bilal.catZone.models.Owner;
import com.bilal.catZone.models_embedded.OwnerImage;
import com.bilal.catZone.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerBuilder {

    @Autowired
    OwnerService ownerService;


    public OwnerBuilder ownerCreator(String name , OwnerImage ownerImage){
        Owner owner = new Owner(name , ownerImage);
        ownerService.addOwner(owner);
        return this;
    }
}
