package com.bootcamp.java.adapter.state;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Created by facun on 02/02/2017.
 */
public class StateJson {

    String country;
    String name;
    String abbr;
    String area;
    String capital;
    String largest_city;

    public StateJson(){}

    public String getLargest_city() {
        return largest_city;
    }

    public void setLargest_city(String largest_city) {
        this.largest_city = largest_city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
