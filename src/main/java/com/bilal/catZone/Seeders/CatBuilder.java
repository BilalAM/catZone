package com.bilal.catZone.Seeders;


import com.bilal.catZone.models.Cat;
import com.bilal.catZone.models_embedded.CatImage;
import com.bilal.catZone.services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatBuilder {

    @Autowired
    private CatService catService;

    public CatBuilder createCat(String name , double furDensity , CatImage catImage){
        Cat cat = new Cat(furDensity,name , catImage);
        catService.addCat(cat);
        return this;
    }

    public CatBuilder createCat(String name , double furDensity){
        Cat cat = new Cat(furDensity,name);
        catService.addCat(cat);
        return this;
    }
}
