package com.bootcamp.java.Controller;

import com.bootcamp.java.Builder.CountryBuilder;
import com.bootcamp.java.Domain.Country;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * Created by facun on 02/02/2017.
 */
public class CountryControllerTest {

    @Test
    public void getCountryById() throws Exception {
        CountryController countryControllerMock = Mockito.mock(CountryController.class);
        ResponseEntity<Country> countryMock = null;
        doReturn(countryMock).when(countryControllerMock).getCountry("Argentina");
        assertEquals(countryMock,countryControllerMock.getCountry("Argentina"));
    }

    public void getCountries() throws Exception{
        CountryController countryControllerMock = Mockito.mock(CountryController.class);
        ResponseEntity<List<Country>> responseEntity = countryControllerMock.getCountries();
        when(countryControllerMock.getCountries()).thenReturn(responseEntity);
        assertEquals(responseEntity,countryControllerMock.getCountries());
    }
}