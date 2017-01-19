package com.bootcamp.java.Builder;

import com.bootcamp.java.Domain.City;

/**
 * Created by facun on 19/01/2017.
 */
public class CityBuilder {

    public String name;
    public int weather_id;
    public int state_id;


    public CityBuilder name(String name)
    {
        this.name =name;
        return this;
    }

    public CityBuilder weather_id(int weather_id)
    {
        this.weather_id = weather_id;
        return this;
    }
    public CityBuilder state_id(int state_id)
    {
        this.state_id = state_id;
        return this;
    }
    public City build()
    {
        return new City(this);
    }
}
