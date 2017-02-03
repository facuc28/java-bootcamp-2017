package com.bootcamp.java.repository;

import com.bootcamp.java.Domain.State;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by facun on 30/01/2017.
 */
public interface StateRepository extends CrudRepository<State, Integer> {


    State findByName(String name);
}
