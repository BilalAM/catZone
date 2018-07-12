package com.bilal.catZone.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CatCharacteristics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String breed;
    private String colour;

    public CatCharacteristics(){

    }

    public CatCharacteristics(String breed , String colour){
        this.breed = breed;
        this.colour = colour;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
