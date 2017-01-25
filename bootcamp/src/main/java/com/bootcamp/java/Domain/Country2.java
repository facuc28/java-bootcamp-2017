package com.bootcamp.java.Domain;

public class Country2{

    int id;
    String countryName;

    public Country2(int i, String countryName) {
        super();
        this.id = i;
        this.countryName = countryName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}