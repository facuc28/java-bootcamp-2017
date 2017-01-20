package com.bootcamp.java.Builder;

import com.bootcamp.java.Domain.Wind;

/**
 * Created by facun on 19/01/2017.
 */
public class WindBuilder {

    public int speed;
    public int direction;

    public WindBuilder speed(int speed)
    {
        this.speed = speed;
        return this;
    }
    public WindBuilder direction(int direction)
    {
        this.direction = direction;
        return this;
    }

    public Wind build()
    {
        return new Wind(this);
    }

}
