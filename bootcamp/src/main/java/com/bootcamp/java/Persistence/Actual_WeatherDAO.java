package com.bootcamp.java.Persistence;

import com.bootcamp.java.Configuration.DataBaseImpl;
import com.bootcamp.java.Domain.Actual_weather;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by facun on 26/01/2017.
 */
public class Actual_WeatherDAO {

    private DataBaseImpl dataBase;

    public void setDataBase(DataBaseImpl dataBase) {
        this.dataBase = dataBase;
    }

    public Actual_weather getActual_Weather(int id_actualWeather)
    {
        //Auxiliares
        Actual_weather AW;
        String sql="SELECT * FROM bootcamp2.actual_weather WHERE id_actualWeather="+id_actualWeather;
        Connection conn;
        PreparedStatement ps;
        try {
            conn = dataBase.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while(res.next())
            {
                AW = new Actual_weather(res.getDouble("temperature"), res.getString("description"), res.getString("date"));
                AW.setId_actualWeather(res.getInt("id_actualWeather"));
                return AW;
            }

        }catch (Exception E)
        {
            E.printStackTrace();
        }
        return null;

    }
}
