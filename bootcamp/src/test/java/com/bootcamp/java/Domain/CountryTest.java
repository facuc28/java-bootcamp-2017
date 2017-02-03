package com.bootcamp.java.Domain;

import com.bootcamp.java.Builder.CountryBuilder;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by facun on 19/01/2017.
 */
public class CountryTest extends TestCase {
    @Test
    public void testGetName() throws Exception {
    Country Argentina = new CountryBuilder()
            .name("Argentina")
            .build();
        assertEquals("Argentina",Argentina.getName());

    }
    @Test
    public void testGetCountry_code2() throws Exception {

        Country C = new CountryBuilder()
                .country_code2("AR")
                .build();
        assertEquals("AR", C.getCountryCode2());
    }
    @Test
    public void testGetCountry_code3() throws Exception {
        Country C = new CountryBuilder()
                .country_code3("ARG")
                .build();
        assertEquals("ARG", C.getCountryCode3());
    }

}