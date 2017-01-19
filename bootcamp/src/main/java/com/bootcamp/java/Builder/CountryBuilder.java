package com.bootcamp.java.Builder;

import com.bootcamp.java.Domain.Country;

/**
 * Created by facun on 19/01/2017.
 */
public class CountryBuilder {

    private  int id_country;
    public String country_code2;
    public String country_code3;
    public String name;

    public CountryBuilder country_code2(String country_code2)
    {
        this.country_code2 = country_code2;
        return this;
    }

    public CountryBuilder country_code3(String country_code3)
    {
        this.country_code3 = country_code3;
        return this;
    }
    public CountryBuilder name(String name)
    {
        this.name = name;
        return this;
    }

    public Country build(){
        return new Country(this);
    }
}
