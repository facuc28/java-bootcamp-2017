package com.bootcamp.java.Persistence;

import com.bootcamp.java.Configuration.DataBaseImpl;
import com.bootcamp.java.Domain.City;
import com.bootcamp.java.Domain.Country;
import com.bootcamp.java.Domain.Weather;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by facun on 26/01/2017.
 */
public class CityDAO {

    private DataBaseImpl dataBase;

    public void setDataBase(DataBaseImpl dataBase) {
        this.dataBase = dataBase;
    }
/*
    public void insertCity(City C)
    {
        //Auxiliaries
        String sql = "INSERT INTO `bootcamp2`.`city` (`name`, `weather_id`, `state_id`) VALUES ('"+C.getName()+"', "+C.getWeather_id()+", "+C.getState_id()+");";
        Connection conn = null;
        PreparedStatement ps=null;

        try {
            conn = dataBase.getConnection();
            ps = conn.prepareStatement(sql);
            ps.execute();
        }catch (Exception E)
        {
            E.printStackTrace();
        }
    }
    */
    /*
    public City getCity(String name)
    {
        String sql="SELECT * FROM bootcamp2.city WHERE name='"+name+"'";
        Connection conn=null;
        PreparedStatement ps = null;
        City C;
        try {
            conn = dataBase.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next())
            {
                C = new City(res.getString("name"), res.getInt("weather_id"), res.getInt("state_id"));
                C.setId_city(res.getInt("id_city"));
                return C;
            }

        }catch (Exception E)
        {
            E.printStackTrace();
        }
      return null;
    }*/

}
