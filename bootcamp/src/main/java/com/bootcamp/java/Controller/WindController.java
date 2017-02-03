package com.bootcamp.java.Controller;

import com.bootcamp.java.Domain.Wind;
import com.bootcamp.java.repository.WindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by facun on 27/01/2017.
 */
@RestController
public class WindController {
    @Autowired
    WindRepository windRepository;

    @RequestMapping(value = "wind/add", method = RequestMethod.POST)
    public ResponseEntity<String> insertWind(@RequestBody Wind wind)
    {
        windRepository.save(wind);
        return new ResponseEntity<String>("Wind added Succesfully", HttpStatus.CREATED);
    }
    @RequestMapping(value = "wind/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Wind> getWindById(@PathVariable int id)
    {
        return new ResponseEntity<Wind>(windRepository.findOne(id),HttpStatus.FOUND);
    }
}
