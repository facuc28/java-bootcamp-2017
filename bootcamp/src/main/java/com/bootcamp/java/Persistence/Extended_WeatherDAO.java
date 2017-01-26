package com.bootcamp.java.Persistence;

import com.bootcamp.java.Configuration.DataBaseImpl;
import com.bootcamp.java.Domain.Extended_weather;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by facun on 26/01/2017.
 */
public class Extended_WeatherDAO {

    private DataBaseImpl dataBase;

    public void setDataBase(DataBaseImpl dataBase) {
        this.dataBase = dataBase;
    }

    public Extended_weather getExtendedWeather(int id_extendedWeather)
    {
        //Auxiliaries
        Extended_weather EW = null;
        String sql="SELECT * FROM bootcamp2.extended_weather WHERE id_extended_weather="+id_extendedWeather;
        Connection conn;
        PreparedStatement ps;
        try {
            conn = dataBase.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while(res.next())
            {
                EW = new Extended_weather(res.getString("description"), res.getString("weekday"), res.getDouble("maximum"), res.getDouble("minimum"), res.getString("date"));
                EW.setId_extendedWeather(res.getInt("id_extended_weather"));
                return EW;
            }

        }catch (Exception E)
        {
            E.printStackTrace();
        }
        return null;

    }
}
