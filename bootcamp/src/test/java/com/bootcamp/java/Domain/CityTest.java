package com.bootcamp.java.Domain;

import com.bootcamp.java.Builder.CityBuilder;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by facun on 19/01/2017.
 */
public class CityTest extends TestCase {

    @Test
    public void testGetName() throws Exception {

        City city = new CityBuilder()
                .name("Almafuerte")
                .build();
        assertEquals("Almafuerte", city.getName());
    }





}