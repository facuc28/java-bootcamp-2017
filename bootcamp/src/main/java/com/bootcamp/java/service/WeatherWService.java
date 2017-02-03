package com.bootcamp.java.service;

import com.bootcamp.java.adapter.weather.Query;
import com.bootcamp.java.adapter.weather.RestResponseWeather;

import javax.ws.rs.*;

/**
 * Created by facun on 02/02/2017.
 */
@Produces("application/json")
public interface WeatherWService {

    //Auxiliaries

    @GET
    @Path("/v1/public/yql")
    @Produces("application/json")
    RestResponseWeather getWeather(@QueryParam("q")String q, @QueryParam("format")String format, @QueryParam("env") String env);

}
