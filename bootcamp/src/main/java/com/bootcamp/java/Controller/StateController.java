package com.bootcamp.java.Controller;


import com.bootcamp.java.Persistence.StateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.java.Domain.State;

/**
 * Created by facun on 26/01/2017.
 */
@RestController
public class StateController {
    @Autowired
    private StateDAO stateDAO;

    @RequestMapping(value = "/state/add", method = RequestMethod.POST)
    public ResponseEntity<String> insertState(@RequestBody State state)
    {
        stateDAO.insertState(state);

        return new ResponseEntity<String>("State successfully added", HttpStatus.CREATED);
    }


}
