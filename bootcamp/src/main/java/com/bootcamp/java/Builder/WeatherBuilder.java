package com.bootcamp.java.Builder;

import com.bootcamp.java.Domain.*;

/**
 * Created by facun on 20/01/2017.
 */
public class WeatherBuilder {

    public Wind wind;
    public Atmosphere atmosphere;
    public Actual_weather actual_weather;
    public Extended_weather extended_weather;
    public String description;

    public  WeatherBuilder wind_id(Wind wind)
    {
        this.wind = wind;
        return this;
    }
    public  WeatherBuilder atmosphere_id(Atmosphere atmosphere)
    {
        this.atmosphere = atmosphere;
        return this;
    }
    public  WeatherBuilder actual_weather_id(Actual_weather actual_weather)
    {
        this.actual_weather = actual_weather;
        return this;
    }
    public  WeatherBuilder extended_weather_id(Extended_weather extended_weather)
    {
        this.extended_weather = extended_weather;
        return this;
    }
    public  WeatherBuilder description(String description)
    {
        this.description = description;
        return this;
    }
    public Weather Build()
    {
        return new Weather(this);
    }

}
