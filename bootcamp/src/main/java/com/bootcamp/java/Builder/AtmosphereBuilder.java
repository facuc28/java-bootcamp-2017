package com.bootcamp.java.Builder;

import com.bootcamp.java.Domain.Atmosphere;

/**
 * Created by facun on 20/01/2017.
 */
public class AtmosphereBuilder {

    public  int humidity;
    public int visibility;
    public int rising;
    public double pressure;


    public AtmosphereBuilder humidity(int humidity)
    {
        this.humidity = humidity;
        return this;
    }
    public  AtmosphereBuilder visibility(int visibility)
    {
        this.visibility = visibility;
        return this;
    }
    public  AtmosphereBuilder rising(int rising)
    {
        this.rising = rising;
        return this;
    }
    public AtmosphereBuilder pressure(double pressure)
    {
        this.pressure = pressure;
        return this;
    }
    public Atmosphere Build()
    {
        return new Atmosphere(this);
    }
}
