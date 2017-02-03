package com.bootcamp.java.Controller;

import com.bootcamp.java.Domain.City;
import com.bootcamp.java.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/**
 * Created by facun on 26/01/2017.
 */
@RestController
public class CityController {
    @Autowired
    private CityRepository cityRepository;

    @RequestMapping(value = "/city/add", method = RequestMethod.POST)
    public ResponseEntity<String> insertCity(@RequestBody City city)
    {

       cityRepository.save(city);

        return new ResponseEntity<String>("City successfully added", HttpStatus.CREATED);
    }
    @RequestMapping(value = "city/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<City> getCity(@PathVariable String name)
    {
        return new ResponseEntity<City>(cityRepository.findByName(name),HttpStatus.FOUND);
    }

}
