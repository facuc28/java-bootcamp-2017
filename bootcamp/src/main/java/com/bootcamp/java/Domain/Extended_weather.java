package com.bootcamp.java.Domain;

import java.sql.ResultSet;
import com.bootcamp.java.Configuration.DataBase;



/**
 * Created by facun on 16/01/2017.
 */
public class Extended_weather {

    private int id_extendedWeather;
    private String description;
    private String weekday;
    private double maximum;
    private double minimum;
    private String date;


    public Extended_weather(){}
    public Extended_weather(String description, String weekday, double maximum, double minimum, String date) {
        id_extendedWeather = getLastID()+1;
        this.description = description;
        this.weekday = weekday;
        this.maximum = maximum;
        this.minimum = minimum;
        this.date = date;
    }

    public int getId_extendedWeather() {
        return id_extendedWeather;
    }

    public void setId_extendedWeather(int id_extendedWeather) {
        this.id_extendedWeather = id_extendedWeather;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public double getMaximum() {
        return maximum;
    }

    public void setMaximum(double maximum) {
        this.maximum = maximum;
    }

    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String text) {
        this.date = text;
    }


    private int getLastID()
    {
        DataBase DB = DataBase.getInstance();
        String sql = "SELECT id_extended_weather FROM bootcamp2.extended_weather";
        ResultSet result = DB.DBRequest(sql);
        boolean flag;
        int mayor=0;
        try {
            while(result.next())
            {
                if (flag=false)
                {
                    mayor = result.getInt("id_extended_weather");
                    flag = true;
                }
                if (result.getInt("id_extended_weather")>mayor)
                {
                    mayor = result.getInt("id_extended_weather");
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
        return "Extended_weather{" +
                "id_extendedWeather=" + id_extendedWeather +
                ", description='" + description + '\'' +
                ", weekday='" + weekday + '\'' +
                ", maximum=" + maximum +
                ", minimum=" + minimum +
                ", date='" + date + '\'' +
                '}';
    }
}