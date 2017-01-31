package com.bootcamp.java.repository;
import com.bootcamp.java.Domain.Country;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by facun on 30/01/2017.
 */

public interface CountryRepository extends CrudRepository<Country, Integer> {

        Country findByName(String name);
        Country findByCountryCode3(String CountryCode);
}
