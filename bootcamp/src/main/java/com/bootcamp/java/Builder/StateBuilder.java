package com.bootcamp.java.Builder;

import com.bootcamp.java.Domain.Country;
import com.bootcamp.java.Domain.State;

/**
 * Created by facun on 19/01/2017.
 */
public class StateBuilder {

    public int id_state;
    public Country country;
    public String name;
    public long area;
    public String capital;
    public String abbrev;

    public StateBuilder country(Country country)
    {
        this.country = country;
        return this;
    }
    public StateBuilder name(String name)
    {
        this.name = name;
        return this;
    }
    public StateBuilder area(long area)
    {
        this.area = area;
        return this;
    }
    public StateBuilder capital(String capital)
    {
        this.capital = capital;
        return this;
    }
    public StateBuilder abbrev(String abbrev)
    {
        this.abbrev = abbrev;
        return this;
    }

    public State build()
    {
        return new State(this);
    }
}
