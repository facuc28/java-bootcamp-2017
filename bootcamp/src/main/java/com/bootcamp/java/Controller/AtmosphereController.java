package com.bootcamp.java.Controller;

import com.bootcamp.java.Domain.Atmosphere;
import com.bootcamp.java.Persistence.AtmosphereDAO;
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
public class AtmosphereController {
    @Autowired
    private AtmosphereDAO atmosphereDAO;

    @RequestMapping(value="/atmosphere/add", method= RequestMethod.POST)
    public ResponseEntity<String> insertAtmosphere(@RequestBody Atmosphere atmosphere){
            atmosphereDAO.insertAtmosphere(atmosphere);
        return new ResponseEntity<String>("Atmosphere added succesfully ", HttpStatus.CREATED);
    }


}
