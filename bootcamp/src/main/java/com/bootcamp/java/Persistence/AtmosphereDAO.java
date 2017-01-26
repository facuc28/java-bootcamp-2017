package com.bootcamp.java.Persistence;

import com.bootcamp.java.Configuration.DataBaseImpl;
import com.bootcamp.java.Domain.Atmosphere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by facun on 26/01/2017.
 */
public class AtmosphereDAO {

    private DataBaseImpl dataBase;

    public void setDataBase(DataBaseImpl dataBase) {
        this.dataBase = dataBase;
    }

    public Atmosphere getAtmosphere(int id_atmosphere)
    {
        String sql="SELECT * FROM bootcamp2.atmosphere WHERE id_atmosphere="+id_atmosphere;
        Connection conn;
        PreparedStatement ps;
        Atmosphere A;
        try {
            conn = dataBase.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet res= ps.executeQuery();
            while(res.next())
            {
                A = new Atmosphere(res.getInt("humidity"), res.getInt("visibility"), res.getInt("rising"), res.getDouble("pressure"));
                A.setId_atmosphere(res.getInt("id_atmosphere"));
                return A;
            }

        }catch (Exception E)
        {
            E.printStackTrace();
        }
        return null;
    }

}
