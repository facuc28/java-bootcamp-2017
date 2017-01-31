package com.bootcamp.java.Domain;

import com.bootcamp.java.Builder.StateBuilder;
import junit.framework.TestCase;

/**
 * Created by facun on 19/01/2017.
 */
public class StateTest extends TestCase {

    public void testGetName() throws Exception {

        State state = new StateBuilder()
                .name("Cordoba")
                .build();
        assertEquals("Cordoba", state.getName());

    }
/*
    public void testGetCountry_id() throws Exception {
        State state = new StateBuilder()
                .country_id(1)
                .build();
        assertEquals(1,state.getCountry_id());

    }
    public void testGetArea() throws Exception{
        State state = new StateBuilder()
                .area(120000)
                .build();
        assertEquals(120000,state.getArea());
    }

    public void testGetCapital() throws Exception {
        State state = new StateBuilder()
                .capital("Cordoba")
                .build();
        assertEquals("Cordoba", state.getCapital());

    }
*/
    public void testGetAbbrev() throws Exception {
        State state = new StateBuilder()
                .abbrev("CO")
                .build();
        assertEquals("CO", state.getAbbrev());
    }

}