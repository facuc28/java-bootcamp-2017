package com.bootcamp.java.Domain;

import com.bootcamp.java.Persistence.CountryDAO;
import com.bootcamp.java.Persistence.DBPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by facun on 25/01/2017.
 */
@RestController
public class CountryRestService {
    @Autowired
    static CountryDAO countryDAO;

    @RequestMapping(value = "/paises", method = RequestMethod.GET,headers="Accept=application/json")
    public List<Country> getCountries()
    {

        List<Country> listOfCountries = new ArrayList<Country>();
        listOfCountries=countryDAO.getCountries();
        return listOfCountries;
    }
}
