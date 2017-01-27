package com.bootcamp.java.Controller;

import com.bootcamp.java.Domain.*;
import com.bootcamp.java.Persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by facun on 26/01/2017.
 */
@RestController
public class WeatherController {
    @Autowired
    WeatherDAO weatherDAO;
    @Autowired
    StateDAO stateDAO;
    @Autowired
    CityDAO cityDAO;
    @Autowired
    AtmosphereDAO atmosphereDAO;
    @Autowired
    Actual_WeatherDAO actual_weatherDAO;
    @Autowired
    Extended_WeatherDAO extended_weatherDAO;
    @Autowired
    WindDAO windDAO;
    @RequestMapping(value = "/weather/{state}/{city}", method = RequestMethod.GET,headers="Accept=application/json")
    public ResponseEntity<WeatherDetail> getWeatherPearCity(@PathVariable String state, @PathVariable String city)
    {
        State S =  stateDAO.getState(state);
        City C = cityDAO.getCity(city);
        Weather W=null;
        if (C.getState_id()==S.getId_state())
        {
            W = weatherDAO.getWeather(C.getWeather_id());
        }
        Atmosphere atmosphere = atmosphereDAO.getAtmosphere(W.getAtmosphere_id());
        Wind wind = windDAO.getWind(W.getWind_id());
        Actual_weather actual_weather = actual_weatherDAO.getActual_Weather(W.getActual_weather_id());
        Extended_weather[] extended_weathers = extended_weatherDAO.getExtendedWeather(W.getId_weather());
        WeatherDetail weatherDetail = new WeatherDetail(W.getId_weather(), wind, atmosphere, actual_weather, extended_weathers, W.getDescription());
        return new ResponseEntity<WeatherDetail>(weatherDetail, HttpStatus.FOUND);
    }

    @RequestMapping(value="/weather/add", method= RequestMethod.POST)
    public ResponseEntity<String> insertWeather(@RequestBody Weather weather){
       weatherDAO.insertWeather(weather);
        return new ResponseEntity<String>("Weather added succesfully ",HttpStatus.CREATED);
    }

}
