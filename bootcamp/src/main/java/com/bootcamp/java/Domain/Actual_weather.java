package com.bootcamp.java.Domain;

import com.bootcamp.java.Configuration.DataBase;

import java.sql.ResultSet;

/**
 * Created by facun on 16/01/2017.
 */
public class Actual_weather {

    private int id_actualWeather;
    private double temperature;
    private  String description;
    private String date;

    public Actual_weather(){}
    public Actual_weather(double temperature, String description, String date) {
        id_actualWeather = getLastID()+1;
        this.temperature = temperature;
        this.description = description;
        this.date = date;
    }

    public int getId_actualWeather() {
        return id_actualWeather;
    }

    public void setId_actualWeather(int id_actualWeather) {
        this.id_actualWeather = id_actualWeather;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private int getLastID()
    {
        DataBase DB = DataBase.getInstance();
        String sql = "SELECT id_actualWeather FROM bootcamp2.actual_weather";
        ResultSet result = DB.DBRequest(sql);
        boolean flag;
        int mayor=0;
        try {
            while(result.next())
            {
                if (flag=false)
                {
                    mayor = result.getInt("id_actualWeather");
                    flag = true;
                }
                if (result.getInt("id_actualWeather")>mayor)
                {
                    mayor = result.getInt("id_actualWeather");
                }
            }
        }catch (Exception E)
        {
            E.printStackTrace();
        }
        return mayor;
    }
    @Override
    public String toString() {
        return "Actual_weather{" +
                "id_actualWeather=" + id_actualWeather +
                ", temperature=" + temperature +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
