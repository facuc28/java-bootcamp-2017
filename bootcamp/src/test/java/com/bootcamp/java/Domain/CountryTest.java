package com.bootcamp.java.Domain;

import com.bootcamp.java.Builder.CountryBuilder;
import junit.framework.TestCase;

/**
 * Created by facun on 19/01/2017.
 */
public class CountryTest extends TestCase {

    public void testGetName() throws Exception {
    Country Argentina = new CountryBuilder()
            .name("Argentina")
            .build();
        assertEquals("Argentina",Argentina.getName());

    }

    public void testGetCountry_code2() throws Exception {

        Country C = new CountryBuilder()
                .country_code2("AR")
                .build();
        assertEquals("AR", C.getCountry_code2());
    }

    public void testGetCountry_code3() throws Exception {
        Country C = new CountryBuilder()
                .country_code3("ARG")
                .build();
        assertEquals("ARG", C.getCountry_code3());
    }

}