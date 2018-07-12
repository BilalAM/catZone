package com.bilal.catZone.models_embedded;


import javax.persistence.*;

@Embeddable
public class OwnerImage {
    private String imagePath;


    private OwnerImage(){

    }

    public OwnerImage(String imagePath){
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
