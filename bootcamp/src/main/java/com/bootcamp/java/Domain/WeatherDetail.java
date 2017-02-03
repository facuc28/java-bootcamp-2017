package com.bootcamp.java.Domain;

/**
 * Created by facun on 26/01/2017.
 */
public class WeatherDetail {

    private int id_weatherDetail;
    private Wind wind;
    private Atmosphere atmosphere;
    private Actual_weather actual_weather;
    private Extended_weather[] extended_weather;
    private String Description;

    public WeatherDetail(Wind wind, Atmosphere atmosphere, Actual_weather actual_weather, Extended_weather[] extended_weather, String description) {
        this.id_weatherDetail = id_weatherDetail;
        this.wind = wind;
        this.atmosphere = atmosphere;
        this.actual_weather = actual_weather;
        this.extended_weather = extended_weather;
        Description = description;
    }

    public int getId_weatherDetail() {
        return id_weatherDetail;
    }

    public void setId_weatherDetail(int id_weatherDetail) {
        this.id_weatherDetail = id_weatherDetail;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public Actual_weather getActual_weather() {
        return actual_weather;
    }

    public void setActual_weather(Actual_weather actual_weather) {
        this.actual_weather = actual_weather;
    }

    public Extended_weather[] getExtended_weather() {
        return extended_weather;
    }

    public void setExtended_weather(Extended_weather[] extended_weather) {
        this.extended_weather = extended_weather;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "WeatherDetail{" +
                "id_weatherDetail=" + id_weatherDetail +
                ", wind=" + wind +
                ", atmosphere=" + atmosphere +
                ", actual_weather=" + actual_weather +
                ", extended_weather=" + extended_weather +
                ", Description='" + Description + '\'' +
                '}';
    }
}
