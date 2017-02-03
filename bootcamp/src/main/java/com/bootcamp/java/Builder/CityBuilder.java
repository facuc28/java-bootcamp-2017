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
    public int id_city;
    public String name;
    @ManyToOne
    @JoinColumn(name = "id_state")
    public State state;

    public int getId_city() {
        return id_city;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }

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
