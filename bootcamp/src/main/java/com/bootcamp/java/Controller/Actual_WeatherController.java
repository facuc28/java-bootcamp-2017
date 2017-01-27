package com.bootcamp.java.Controller;

import com.bootcamp.java.Domain.Actual_weather;
import com.bootcamp.java.Domain.Country;
import com.bootcamp.java.Persistence.Actual_WeatherDAO;
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
public class Actual_WeatherController {
    @Autowired
    private Actual_WeatherDAO actual_weatherDAO;

    @RequestMapping(value="/actualweather/add", method= RequestMethod.POST)
    public ResponseEntity<String> insertActual_Weather(@RequestBody Actual_weather actual_weather){
            actual_weatherDAO.insertActualWeather(actual_weather);
        return new ResponseEntity<String>("Actual weather added succesfully ", HttpStatus.CREATED);
    }
}
