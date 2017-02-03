package com.bootcamp.java.Controller;


import com.bootcamp.java.Domain.Extended_weather;
import com.bootcamp.java.Domain.Weather;
import com.bootcamp.java.repository.ExtendedWeatherRepository;
import com.bootcamp.java.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by facun on 27/01/2017.
 */
@RestController
public class Extended_WeatherController {
    @Autowired
    ExtendedWeatherRepository extendedWeatherRepository;
    @Autowired
    WeatherRepository weatherRepository;
    @RequestMapping(value="/extendedweather/{weatherID}/add", method= RequestMethod.POST)
    public ResponseEntity<String> insertExtended_Weather(@RequestBody Extended_weather extended_weather, @PathVariable int weatherID){
        Weather W =weatherRepository.findOne(weatherID);
        extended_weather.setWeather(W);
        extendedWeatherRepository.save(extended_weather);
        return new ResponseEntity<String>("Extended weather added succesfully ", HttpStatus.CREATED);
    }
    @RequestMapping(value = "extendedweather/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Extended_weather> getExtendedWeather(@PathVariable int id)
    {
        return new ResponseEntity<Extended_weather>(extendedWeatherRepository.findOne(id), HttpStatus.FOUND);
    }
}
