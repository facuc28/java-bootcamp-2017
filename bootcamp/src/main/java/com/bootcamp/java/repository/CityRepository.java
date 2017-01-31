package com.bootcamp.java.repository;

import com.bootcamp.java.Domain.City;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by facun on 30/01/2017.
 */
public interface CityRepository extends CrudRepository<City, Integer> {
}
