package com.bilal.catZone.models_embedded;

import javax.persistence.*;

@Embeddable
public class CatImage {

    private String imagePath;

    private CatImage(){

    }
    public CatImage(String imagePath){
        this.setImagePath(imagePath);
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
