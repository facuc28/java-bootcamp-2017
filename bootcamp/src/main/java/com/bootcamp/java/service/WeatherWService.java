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
    Query getWeather(@DefaultValue("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"nome, ak\"")@QueryParam("q")String query,@DefaultValue("json") @QueryParam("format")String format, @DefaultValue("store://datatables.org/alltableswithkeys")@QueryParam("env")String env);

}
