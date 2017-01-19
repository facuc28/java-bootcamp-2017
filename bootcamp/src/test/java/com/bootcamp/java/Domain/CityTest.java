package com.bootcamp.java.Domain;

import com.bootcamp.java.Builder.CityBuilder;
import junit.framework.TestCase;

/**
 * Created by facun on 19/01/2017.
 */
public class CityTest extends TestCase {


    public void testGetName() throws Exception {

        City city = new CityBuilder()
                .name("Almafuerte")
                .build();
        assertEquals("Almafuerte", city.getName());
    }

    public void testGetWeather_id() throws Exception {

        City city = new CityBuilder()
                .weather_id(1)
                .build();
        assertEquals(1,city.getWeather_id());
    }

    public void testGetState_id() throws Exception {

        City city = new CityBuilder()
                .state_id(1)
                .build();
        assertEquals(1,city.getState_id());
    }

}