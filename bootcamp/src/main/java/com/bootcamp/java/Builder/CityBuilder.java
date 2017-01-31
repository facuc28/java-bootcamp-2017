package com.bootcamp.java.Builder;

import com.bootcamp.java.Domain.City;
import com.bootcamp.java.Domain.State;
import jdk.nashorn.internal.runtime.logging.Logger;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by facun on 19/01/2017.
 */
public class CityBuilder {
    @Id
    @GeneratedValue
    private int id_city;
    public String name;
    @ManyToOne
    @JoinColumn(name = "id_state")
    public State state;


    public CityBuilder name(String name)
    {
        this.name =name;
        return this;
    }

    public CityBuilder state_id(State state)
    {
        this.state = state;
        return this;
    }
    public City build()
    {
        return new City(this);
    }
}
