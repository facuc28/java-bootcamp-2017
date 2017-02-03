package com.bootcamp.java.service;

import com.bootcamp.java.Domain.Country;
import com.bootcamp.java.adapter.country.RestResponse;
import com.bootcamp.java.adapter.state.RestResponseState;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import javax.ws.rs.*;


/**
 * Created by facun on 31/01/2017.
 */


@Produces("application/json")
public interface CountryWService {
    @GET
    @Path("/{name}")
    @Produces("application/json")
    ResponseEntity<Country> getCountryByName(@PathParam("name") String name);
    @POST
    @Path("/add")
    @Consumes("application/json")
    ResponseEntity<String> saveCountry(@RequestBody Country country);
    @GET
    @Path("/country/get/all")
    @Produces("application/json")
    RestResponse getCountries();
    @GET
    @Path("state/get/{country}/all")
    @Produces("application/json")
    RestResponseState getStates(@PathParam("country") String country);



}
