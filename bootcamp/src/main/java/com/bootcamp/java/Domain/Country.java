package com.bootcamp.java.Domain;

import com.bootcamp.java.Builder.CountryBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;

/**
 * Created by facun on 16/01/2017.
 */
@Entity
@Table(name = "country")
public class Country {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id_country;
    @Column(length = 2)
    private String countryCode2;
    @Column(length = 3)
    private String countryCode3;
    private String name;

    public Country(){}

    public Country(CountryBuilder builder)
    {
        this.countryCode2 = builder.country_code2;
        this.countryCode3 = builder.country_code3;
        this.name = builder.name;

    }
    public Country(String countryCode2, String countryCode3, String name) {

        this.countryCode2 = countryCode2;
        this.countryCode3 = countryCode3;
        this.name = name;
    }

    public int getId_country() {
        return id_country;
    }

    public void setId_country(int id_country) {
        this.id_country = id_country;
    }

    public String getCountryCode2() {
        return countryCode2;
    }

    public void setCountryCode2(String countryCode2) {
        this.countryCode2 = countryCode2;
    }

    public String getCountryCode3() {
        return countryCode3;
    }

    public void setCountryCode3(String countryCode3) {
        this.countryCode3 = countryCode3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Country{" +
                "id_country=" + id_country +
                ", countryCode2='" + countryCode2 + '\'' +
                ", countryCode3='" + countryCode3 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
