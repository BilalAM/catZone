package com.bilal.catZone.models_embedded;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String streetCode;
    private String areaCode;

    public Address(){

    }

    public Address(String streetCode , String areaCode){
        this.streetCode = streetCode;
        this.areaCode = areaCode;
    }
    public String getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}
