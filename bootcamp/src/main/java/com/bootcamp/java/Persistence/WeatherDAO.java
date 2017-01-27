package com.bootcamp.java.Persistence;

import com.bootcamp.java.Configuration.DataBaseImpl;
import com.bootcamp.java.Domain.Weather;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by facun on 26/01/2017.
 */
public class WeatherDAO {

    private DataBaseImpl dataBase;

    public void setDataBase(DataBaseImpl dataBase) {
        this.dataBase = dataBase;
    }

    public Weather getWeather(int id_weather)
    {
        String sql="SELECT * FROM bootcamp2.weather WHERE id_weather="+id_weather;
        Connection conn;
        PreparedStatement ps;
        Weather W;
        try {
            conn = dataBase.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while(res.next())
            {
                W = new Weather(res.getInt("wind_id"),res.getInt("atmosphere_id"), res.getInt("actual_weather_id"), res.getInt("extended_weather_id"), res.getString("description"));
                W.setId_weather(res.getInt("id_weather"));
                return W;
            }

        }catch (Exception E)
        {
            E.printStackTrace();
        }
        return null;
    }

    public void insertWeather(Weather W)
    {
        //Auxiliaries
        String sql = "INSERT INTO `bootcamp2`.`weather` (`wind_id`, `atmosphere_id`, `actual_weather_id`, `extended_weather_id`, `description`) VALUES ("+W.getWind_id()+", "+W.getAtmosphere_id()+", "+W.getActual_weather_id()+", "+W.getExtended_weather_id()+", '"+W.getDescription()+"');";
        Connection conn;
        PreparedStatement ps;
        try {
            conn = dataBase.getConnection();
            ps = conn.prepareStatement(sql);
            ps.execute();
        }catch (Exception E)
        {
            E.printStackTrace();
        }
    }
}
