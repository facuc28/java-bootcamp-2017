package com.bootcamp.java.Domain;

import com.bootcamp.java.Builder.Actual_WeatherBuilder;
import com.bootcamp.java.Builder.AtmosphereBuilder;
import com.bootcamp.java.Configuration.DataBase;

import java.sql.ResultSet;

/**
 * Created by facun on 16/01/2017.
 */
public class Atmosphere {

    private int id_atmosphere;
    private  int humidity;
    private int visibility;
    private int rising;
    private double pressure;


    public Atmosphere(){}
    public Atmosphere(int humidity, int visibility, int rising, double pressure) {
        id_atmosphere = getLastID()+1;
        this.humidity = humidity;
        this.visibility = visibility;
        this.rising = rising;
        this.pressure = pressure;
    }
    public Atmosphere(AtmosphereBuilder builder)
    {
        this.humidity = builder.humidity;
        this.visibility = builder.visibility;
        this.rising = builder.rising;
        this.pressure = builder.pressure;
    }

    public Atmosphere(Actual_WeatherBuilder builder) {}

    public int getId_atmosphere() {
        return id_atmosphere;
    }

    public void setId_atmosphere(int id_atmosphere) {
        this.id_atmosphere = id_atmosphere;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getRising() {
        return rising;
    }

    public void setRising(int rising) {
        this.rising = rising;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    private int getLastID()
    {
        DataBase DB = DataBase.getInstance();
        String sql = "SELECT id_atmosphere FROM bootcamp2.atmosphere";
        ResultSet result = DB.DBRequest(sql);
        boolean flag;
        int mayor=0;
        try {
            while(result.next())
            {
                if (flag=false)
                {
                    mayor = result.getInt("id_atmosphere");
                    flag = true;
                }
                if (result.getInt("id_atmosphere")>mayor)
                {
                    mayor = result.getInt("id_atmosphere");
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
        return "Atmosphere{" +
                "id_atmosphere=" + id_atmosphere +
                ", humidity=" + humidity +
                ", visibility=" + visibility +
                ", rising=" + rising +
                ", pressure=" + pressure +
                '}';
    }
}
