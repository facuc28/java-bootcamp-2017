package com.bootcamp.java.Controller;

import com.bootcamp.java.Domain.Wind;
import com.bootcamp.java.Persistence.WindDAO;
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
public class WindController {
    @Autowired
    private WindDAO windDAO;

    @RequestMapping(value = "wind/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> insertWind(@RequestBody Wind wind)
    {
        windDAO.insertWind(wind);
        return new ResponseEntity<String>("Wind added Succesfully", HttpStatus.CREATED);
    }
}