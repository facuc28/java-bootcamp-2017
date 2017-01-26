package com.bootcamp.java.Persistence;

import com.bootcamp.java.Configuration.DataBaseImpl;
import com.bootcamp.java.Domain.Wind;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by facun on 26/01/2017.
 */
public class WindDAO {

    private DataBaseImpl dataBase;

    public void setDataBase(DataBaseImpl dataBase) {
        this.dataBase = dataBase;
    }

    public Wind getWind(int id_wind){

        //Auxiliaries
        Wind W = null;
        String sql="SELECT * FROM bootcamp2.wind WHERE id_wind="+id_wind;
        Connection conn;
        PreparedStatement ps;

        try {
            conn = dataBase.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while(res.next())
            {
                W = new Wind(res.getInt("speed"), res.getInt("direction"));
                W.setId_wind(res.getInt("id_wind"));
                return W;
            }

        }catch (Exception E)
        {
            E.printStackTrace();
        }
        return null;
    }
}
