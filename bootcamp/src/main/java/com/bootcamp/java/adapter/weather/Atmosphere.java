package com.bootcamp.java.adapter.weather;

/**
 * Created by facun on 02/02/2017.
 */
public class Atmosphere {

    private int humidity;
    private double pressure;
    private int rising;
    private int visibility;

    public Atmosphere(){}

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getRising() {
        return rising;
    }

    public void setRising(int rising) {
        this.rising = rising;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }
}
