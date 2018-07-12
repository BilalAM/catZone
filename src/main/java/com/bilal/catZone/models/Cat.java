package com.bilal.catZone.models;



import com.bilal.catZone.models_embedded.CatImage;

import javax.persistence.*;


// catName property is used to define the catName of the table OR column
// if none specified it creates class catName as table catName
@Entity
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double furDensity;

    private String catName;


    @Embedded
    private CatImage catImage;

    @OneToOne
    @JoinColumn(name = "cat_characteristics_id")
    private CatCharacteristics catCharacteristics;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ownerId")
    private Owner owner;


    public Cat(double furDensity , String catName){
        this.furDensity = furDensity;
        this.catName = catName;
    }

    public Cat(double furDensity , String catName, CatImage catImage){
        this.furDensity = furDensity;
        this.catName = catName;
        this.catImage = catImage;
    }
    private Cat(){

    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public double getFurDensity() {
        return furDensity;
    }

    public void setFurDensity(double furDensity) {
        this.furDensity = furDensity;
    }


    @Override
    public String toString(){
        return "[NAME : " + catName + " FUR DENSITY : " + furDensity + " ] ";
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CatCharacteristics getCatCharacteristics() {
        return catCharacteristics;
    }

    public void setCatCharacteristics(CatCharacteristics catCharacteristics) {
        this.catCharacteristics = catCharacteristics;
    }

    public CatImage getCatImage() {
        return catImage;
    }

    public void setCatImage(CatImage catImage) {
        this.catImage = catImage;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
