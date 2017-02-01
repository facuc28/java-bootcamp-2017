package com.bootcamp.java.proxy;

import com.bootcamp.java.Domain.Country;
import com.bootcamp.java.adapter.AdapterCountry;
import com.bootcamp.java.adapter.CountryJson;
import com.bootcamp.java.adapter.RestResponse;
import com.bootcamp.java.repository.ExtendedWeatherRepository;
import com.bootcamp.java.service.CountryWService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by facun on 01/02/2017.
 */
@Component
public class Proxy {
    @Resource
    CountryWService countryWService;


    public Proxy(){}

    public List<Country> getCountries(){
        List<Country> listOfCountries = new ArrayList<>();
        RestResponse restResponse = countryWService.getCountries();
        Country C=null;
        for (CountryJson CJ: restResponse.getAdapterCountry().getListOfCounties())
        {
            C = new Country(CJ.getAlpha2_code(), CJ.getAlpha3_code(), CJ.getName());
            listOfCountries.add(C);
        }
        return listOfCountries;
    }


}
