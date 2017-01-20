package com.bootcamp.java.Builder;

import com.bootcamp.java.Domain.Extended_weather;

/**
 * Created by facun on 20/01/2017.
 */
public class Extended_WeatherBuilder {

    public String description;
    public String weekday;
    public double maximum;
    public double minimum;
    public String date;

    public Extended_WeatherBuilder description(String description)
    {
        this.description = description;
        return this;
    }
    public Extended_WeatherBuilder weekday(String weekday)
    {
        this.weekday = weekday;
        return this;
    }
    public Extended_WeatherBuilder maximum(double maximum)
    {
        this.maximum = maximum;
        return this;
    }
    public Extended_WeatherBuilder minimum(double minimum)
    {
        this.minimum = minimum;
        return this;
    }
    public Extended_WeatherBuilder date(String date)
    {
        this.date = date;
        return this;
    }
    public Extended_weather Build()
    {
        return new Extended_weather(this);
    }
}
