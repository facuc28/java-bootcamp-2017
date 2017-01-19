package com.bootcamp.java.Domain;

import com.bootcamp.java.Configuration.DataBase;

import java.sql.ResultSet;

/**
 * Created by facun on 16/01/2017.
 */
public class City {

    private int id_city;
    private String name;
    private int weather_id;
    private int state_id;

    public City(){}
    public City(String name, int weather_id, int state_id) {
        id_city = getLastID()+1;
        this.name = name;
        this.weather_id = weather_id;
        this.state_id = state_id;
    }

    public int getId_city() {
        return id_city;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeather_id() {
        return weather_id;
    }

    public void setWeather_id(int weather_id) {
        this.weather_id = weather_id;
    }

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    private int getLastID()
    {
        DataBase DB = DataBase.getInstance();
        String sql = "SELECT id_city FROM bootcamp2.city";
        ResultSet result = DB.DBRequest(sql);
        boolean flag;
        int mayor=0;
        try {
            while(result.next())
            {
                if (flag=false)
                {
                    mayor = result.getInt("id_city");
                    flag = true;
                }
                if (result.getInt("id_city")>mayor)
                {
                    mayor = result.getInt("id_city");
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
        return "City{" +
                "id_city=" + id_city +
                ", name='" + name + '\'' +
                ", weather_id=" + weather_id +
                ", state_id=" + state_id +
                '}';
    }
}