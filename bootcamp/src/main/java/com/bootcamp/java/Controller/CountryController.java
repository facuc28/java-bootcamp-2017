package com.bootcamp.java.Controller;

import com.bootcamp.java.Domain.Country;

import com.bootcamp.java.repository.CountryRepository;
import com.bootcamp.java.service.CountryWService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by facun on 25/01/2017.
 */
@Controller
@Path("/country")
@Produces("application/json")
public class CountryController{
    @Autowired
    CountryRepository countryRepository;

    @GET
    @Path("/")
    @Produces("application/json")
    public ResponseEntity<List<Country>> getCountries()
    {
        List<Country> listOfCountries = new ArrayList<>();
        countryRepository.findAll().forEach(listOfCountries::add);
        return new ResponseEntity<List<Country>>(listOfCountries,HttpStatus.FOUND);
    }

    @GET
    @Path("/name/{name}")
    @Produces("application/json")
    public ResponseEntity<Country> getCountry(@PathParam("name")String name)
    {
        Country C;
        C = countryRepository.findByName(name);
        return new ResponseEntity<Country>(C, HttpStatus.FOUND);
    }
    @POST
    @Path("/add")
    public ResponseEntity<String> insertCountry(Country country){
        countryRepository.save(country);
        return new ResponseEntity<String>("Country added succesfully ",HttpStatus.CREATED);
    }
}
