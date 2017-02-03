package com.bootcamp.java.service;

import com.bootcamp.java.adapter.weather.Query;

import javax.ws.rs.*;

/**
 * Created by facun on 02/02/2017.
 */
@Produces("application/json")
public interface WeatherWService {

    //Auxiliaries

    @GET
    @Path("")
    @Produces("application/json")
    Query getWeather(@PathParam("state")String state,@PathParam("city") String city);

}
