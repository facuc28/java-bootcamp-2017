package com.bootcamp.java.repository;

import com.bootcamp.java.Domain.Extended_weather;
import com.bootcamp.java.Persistence.Extended_WeatherDAO;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;


public interface ExtendedWeatherRepository extends CrudRepository<Extended_weather,Integer> {
}
