package com.bootcamp.java.service;

import com.bootcamp.java.Domain.Country;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebService;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by facun on 31/01/2017.
 */
@WebService
@Path("/country")
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
    @Path("/")
    @Produces("application/json")
    ResponseEntity<List<Country>> getCountries();
}
