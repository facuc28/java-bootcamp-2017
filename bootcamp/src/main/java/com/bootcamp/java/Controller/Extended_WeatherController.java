package com.bootcamp.java.Controller;

import com.bootcamp.java.Domain.Country;
import com.bootcamp.java.Domain.Extended_weather;
import com.bootcamp.java.Persistence.Extended_WeatherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by facun on 27/01/2017.
 */
@RestController
public class Extended_WeatherController {
    @Autowired
    private Extended_WeatherDAO extended_weatherDAO;
    @RequestMapping(value="/extendedweather/add", method= RequestMethod.POST)
    public ResponseEntity<String> insertExtended_Weather(@RequestBody Extended_weather extended_weather){
        extended_weatherDAO.insertExtendedWeather(extended_weather);
        return new ResponseEntity<String>("Extended weather added succesfully ", HttpStatus.CREATED);
    }
}
