package com.bootcamp.java.repository;

import com.bootcamp.java.Domain.Actual_weather;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by facun on 30/01/2017.
 */
public interface ActualWeatherRepository extends CrudRepository<Actual_weather, Integer> {
}
