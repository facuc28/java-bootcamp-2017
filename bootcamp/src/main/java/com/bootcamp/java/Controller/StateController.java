package com.bootcamp.java.Controller;


import com.bootcamp.java.Domain.Country;
import com.bootcamp.java.proxy.Proxy;
import com.bootcamp.java.repository.CountryRepository;
import com.bootcamp.java.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.java.Domain.State;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by facun on 26/01/2017.
 */
@RestController
public class StateController {
    @Autowired
    StateRepository stateRepository;
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    Proxy proxy;
    @RequestMapping(value = "/state/add", method = RequestMethod.POST)
    public ResponseEntity<String> insertState(@RequestBody State state)
    {
        Country C = countryRepository.findByCountryCode3(state.getCountryCode3());
        state.setCountry(C);
        stateRepository.save(state);
        return new ResponseEntity<String>("State successfully added", HttpStatus.CREATED);
    }
    @RequestMapping(value = "/state/{country}")
    public ResponseEntity<List<State>> getStates(@PathVariable String country)
    {
        if (proxy.getStates(country)==null)
        {
            List<State> listOfStates = new ArrayList<>();
            stateRepository.findAll().forEach(listOfStates::add);
            return new ResponseEntity<List<State>>(listOfStates,HttpStatus.FOUND);
        }
        return  new ResponseEntity<List<State>>(proxy.getStates(country), HttpStatus.FOUND);
    }


}
