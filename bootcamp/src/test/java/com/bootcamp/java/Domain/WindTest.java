package com.bootcamp.java.Domain;

import com.bootcamp.java.Builder.WindBuilder;
import junit.framework.TestCase;

/**
 * Created by facun on 19/01/2017.
 */
public class WindTest extends TestCase {

    public void testGetSpeed() throws Exception {

        Wind wind = new WindBuilder()
                .speed(10)
                .build();
        assertEquals(10,wind.getSpeed());
    }

    public void testGetDirection() throws Exception {

        Wind wind = new WindBuilder()
                .direction(2)
                .build();
        assertEquals(2,wind.getDirection());
    }

}