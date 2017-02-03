package com.bootcamp.java.Domain;

import com.bootcamp.java.Builder.WeatherBuilder;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

/**
 * Created by facun on 16/01/2017.
 */
@Entity
@Table(name = "weather")
public class Weather {
        @javax.persistence.Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id_weather;
        @ManyToOne
        @JoinColumn(name = "id_wind")
        private Wind wind;
        @ManyToOne
        @JoinColumn(name = "id_atmosphere")
        private Atmosphere atmosphere;
        @ManyToOne
        @JoinColumn(name = "actual_weather_id")
        private Actual_weather actual_weather;
        @ManyToOne
        @JoinColumn(name = "extended_weather_id")
        private Extended_weather extended_weather;
        private String description;
        private int idCity;

    public  Weather(){}


    public Weather(WeatherBuilder builder)
    {
       this.wind = builder.wind;
        this.atmosphere = builder.atmosphere;
        this.actual_weather = builder.actual_weather;
        this.extended_weather = builder.extended_weather;
        this.description = builder.description;
    }

    public Weather(int id_weather, Wind wind, Atmosphere atmosphere, Actual_weather actual_weather, Extended_weather extended_weather, String description) {
        this.id_weather = id_weather;
        this.wind = wind;
        this.atmosphere = atmosphere;
        this.actual_weather = actual_weather;
        this.extended_weather = extended_weather;
        this.description = description;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public int getId_weather() {
        return id_weather;
    }

    public void setId_weather(int id_weather) {
        this.id_weather = id_weather;
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

    public Extended_weather getExtended_weather() {
        return extended_weather;
    }

    public void setExtended_weather(Extended_weather extended_weather) {
        this.extended_weather = extended_weather;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id_weather=" + id_weather +
                ", wind=" + wind +
                ", atmosphere=" + atmosphere +
                ", actual_weather=" + actual_weather +
                ", extended_weather=" + extended_weather +
                ", description='" + description + '\'' +
                '}';
    }
}
