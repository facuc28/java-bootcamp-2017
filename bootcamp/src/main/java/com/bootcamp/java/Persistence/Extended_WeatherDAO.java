package com.bootcamp.java.Persistence;

import com.bootcamp.java.Configuration.DataBaseImpl;
import com.bootcamp.java.Domain.Extended_weather;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by facun on 26/01/2017.
 */
public class Extended_WeatherDAO {

    private DataBaseImpl dataBase;

    public void setDataBase(DataBaseImpl dataBase) {
        this.dataBase = dataBase;
    }
    /*
    public Extended_weather[] getExtendedWeather(int id_weather)
    {
        //Auxiliaries
        int cont = 0;
        Extended_weather EW;
        Extended_weather[] extended_weathers = new Extended_weather[10];
        String sql="SELECT * FROM bootcamp2.extended_weather WHERE weather_id="+id_weather;
        Connection conn;
        PreparedStatement ps;
        try {
            conn = dataBase.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet res = ps.executeQuery();

            while(res.next())
            {
                if (cont<=10)
                {
                    EW = new Extended_weather(res.getString("description"), res.getString("weekday"), res.getDouble("maximum"), res.getDouble("minimum"), res.getString("date"), res.getInt("weather_id"));
                    EW.setId_extendedWeather(res.getInt("id_extended_weather"));
                    extended_weathers[cont]=EW;
                    cont++;
                }

            }

        }catch (Exception E)
        {
            E.printStackTrace();
        }
        return extended_weathers;

    }
*/
    public void insertExtendedWeather(Extended_weather EW)
    {
        //Auxiliaries
        String sql = "INSERT INTO `bootcamp2`.`extended_weather` (`description`, `weekday`, `maximum`, `minimum`, `date`) VALUES ('"+EW.getDescription()+"', '"+EW.getWeekday()+"', '"+EW.getMaximum()+"', '"+EW.getMinimum()+"', '"+EW.getDate()+"');";
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
