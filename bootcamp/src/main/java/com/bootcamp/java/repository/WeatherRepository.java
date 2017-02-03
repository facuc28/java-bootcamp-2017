package com.bootcamp.java.repository;

import com.bootcamp.java.Domain.Weather;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by facun on 30/01/2017.
 */
public interface WeatherRepository extends CrudRepository<Weather, Integer> {

    Weather findByIdCity(int idCity);
}
