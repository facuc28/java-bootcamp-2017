package com.bootcamp.java.Controller;

import com.bootcamp.java.Domain.Atmosphere;
import com.bootcamp.java.repository.AtmosphereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by facun on 27/01/2017.
 */
@RestController
public class AtmosphereController {
    @Autowired
    AtmosphereRepository atmosphereRepository;

    @RequestMapping(value="/atmosphere/add", method= RequestMethod.POST)
    public ResponseEntity<String> insertAtmosphere(@RequestBody Atmosphere atmosphere){
            atmosphereRepository.save(atmosphere);
        return new ResponseEntity<String>("Atmosphere added succesfully ", HttpStatus.CREATED);
    }
    @RequestMapping(value = "atmosphere/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Atmosphere> getAtmosphereById(@PathVariable int id)
    {
        return new ResponseEntity<Atmosphere>(atmosphereRepository.findOne(id),HttpStatus.FOUND);
    }

}
