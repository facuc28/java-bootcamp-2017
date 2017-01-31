package com.bootcamp.java.Controller;

import com.bootcamp.java.Domain.Country;
import com.bootcamp.java.Persistence.CountryDAO;
import com.bootcamp.java.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by facun on 25/01/2017.
 */
@RestController
public class CountryController {
    @Autowired
    CountryRepository countryRepository;

    @RequestMapping(value = "/countries", method = RequestMethod.GET,headers="Accept=application/json")
    public ResponseEntity<List<Country>> getCountries()
    {
        List<Country> listOfCountries = new ArrayList<>();
        countryRepository.findAll().forEach(listOfCountries::add);
        return new ResponseEntity<List<Country>>(listOfCountries,HttpStatus.FOUND);
    }
    @RequestMapping(value = "/country/{name}", method = RequestMethod.GET,headers="Accept=application/json")
    public ResponseEntity<Country> getCountry(@PathVariable String name)
    {
        Country C;
        C = countryRepository.findByName(name);
        return new ResponseEntity<Country>(C, HttpStatus.FOUND);
    }

    @RequestMapping(value="/country/add", method= RequestMethod.POST)
    public ResponseEntity<String> insertCountry(@RequestBody Country country){
          countryRepository.save(country);
        return new ResponseEntity<String>("Country added succesfully ",HttpStatus.CREATED);
    }

}
