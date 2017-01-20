package com.bootcamp.java.Builder;

import com.bootcamp.java.Domain.Weather;

/**
 * Created by facun on 20/01/2017.
 */
public class WeatherBuilder {

    public int wind_id;
    public int atmosphere_id;
    public int actual_weather_id;
    public int extended_weather_id;
    public String description;

    public  WeatherBuilder wind_id(int wind_id)
    {
        this.wind_id = wind_id;
        return this;
    }
    public  WeatherBuilder atmosphere_id(int atmosphere_id)
    {
        this.atmosphere_id = atmosphere_id;
        return this;
    }
    public  WeatherBuilder actual_weather_id(int actual_weather_id)
    {
        this.actual_weather_id = actual_weather_id;
        return this;
    }
    public  WeatherBuilder extended_weather_id(int extended_weather_id)
    {
        this.extended_weather_id = extended_weather_id;
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
