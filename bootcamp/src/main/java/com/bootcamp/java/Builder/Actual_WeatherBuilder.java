package com.bootcamp.java.Builder;

import com.bootcamp.java.Domain.Actual_weather;
import com.bootcamp.java.Domain.Atmosphere;

/**
 * Created by facun on 19/01/2017.
 */
public class Actual_WeatherBuilder {

    public double temperature;
    public   String description;
    public String date;

    public Actual_WeatherBuilder temperature(double temperature)
    {
        this.temperature = temperature;
        return this;
    }
    public Actual_WeatherBuilder description(String description)
    {
        this.description = description;
        return this;
    }
    public Actual_WeatherBuilder date(String date)
    {
        this.date = date;
        return this;
    }

    public Actual_weather Build()
    {
        return new Actual_weather(this);
    }


}
