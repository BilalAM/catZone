package com.bilal.catZone.services;


import com.bilal.catZone.models.Cat;
import com.bilal.catZone.repos.CatRepository;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@Service
public class CatService {

    @Autowired
    private CatRepository catRepository;

    @Autowired
    private Environment environment;

    public void addCat(Cat cat){
        catRepository.save(cat);
    }

    public void allAllCats(Cat... cats){
        catRepository.saveAll(List.of(cats));
    }

    public List<Cat> findAllCats(){
        return catRepository.findAll();
    }

    public void deleteCat(int id){
        Cat catToDelete = catRepository.findById(id).get();
        removeUploadedImage(catToDelete);
        catRepository.deleteById(id);
    }

    public void deleteCat(Cat cat){
        catRepository.delete(cat);
    }

    public Cat getCat(int id){
        return catRepository.findById(id).get();
    }

    public Cat updateCat(Cat cat){
        return catRepository.save(cat);
    }

    /**
     * returns whether the cat has a owner or not
     * @param cat the cat to be tested
     * @return true if owner is present , false otherwise
     */
    public boolean hasOwner(Cat cat){ return !(Objects.isNull(cat.getOwner()));}

    private void removeUploadedImage(Cat ofCat){
        if(hasImage(ofCat)){
            try {
                File file = new File(environment.getProperty("uploaded.cat.images") + "/" + ofCat.getCatName() + ".jpg");
                Files.delete(Paths.get(file.toURI()));
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
        }
    }
    private boolean hasImage(Cat cat){
        return (!Objects.isNull(cat.getCatImage()));
    }


}

