package com.bootcamp.java.Controller;

import com.bootcamp.java.Domain.*;
import com.bootcamp.java.proxy.Proxy;
import com.bootcamp.java.repository.CityRepository;
import com.bootcamp.java.repository.StateRepository;
import com.bootcamp.java.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;

/**
 * Created by facun on 26/01/2017.
 */
@RestController
public class WeatherController {
    @Autowired
    private WeatherRepository weatherRepository;
    @Autowired
    Proxy proxy;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    StateRepository stateRepository;


    @RequestMapping(value = "/weather/db/{state}/{city}", method = RequestMethod.GET,headers="Accept=application/json")
    public ResponseEntity<WeatherDetail> getWeatherForCity(@PathVariable String state, @PathVariable String city)
    {
        return new ResponseEntity<WeatherDetail>(proxy.getWeatherForCity(state,city), HttpStatus.FOUND);
    }

    @RequestMapping(value="/weather/add", method= RequestMethod.POST)
    public ResponseEntity<String> insertWeather(@RequestBody Weather weather){
     weatherRepository.save(weather);
        return new ResponseEntity<String>("Weather added succesfully ",HttpStatus.CREATED);
    }
    @RequestMapping(value = "/weather/{state}/{city}", method = RequestMethod.GET, headers="Accept=application/json")
    public  ResponseEntity<WeatherDetail> getWeather(@PathVariable String state, @PathVariable String city)
    {
        return new ResponseEntity<WeatherDetail>(proxy.getWeather(state,city),HttpStatus.FOUND);
    }
}
