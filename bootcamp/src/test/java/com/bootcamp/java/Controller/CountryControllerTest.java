package com.bootcamp.java.Controller;

import com.bootcamp.java.Domain.Country;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.doReturn;

/**
 * Created by facun on 02/02/2017.
 */
public class CountryControllerTest extends TestCase {
  /*
    @Test
    public void getCountryById() throws Exception {
        CountryController countryControllerMock = Mockito.mock(CountryController.class);
        ResponseEntity<Country> countryMock = new ResponseEntity<Country>(HttpStatus.OK);
        doReturn(countryMock).when(countryControllerMock).getCountry("Argentina");
        assertEquals(countryMock,countryControllerMock.getCountry("Argentina"));
    }

*/
  @Test
    public void testRandom()
  {}
}