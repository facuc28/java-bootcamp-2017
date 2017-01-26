package com.bootcamp.java.Persistence;
import com.bootcamp.java.Configuration.DataBaseImpl;
import com.bootcamp.java.Domain.State;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by facun on 26/01/2017.
 */
public class StateDAO {

    private DataBaseImpl dataBase;

    public void setDataBase(DataBaseImpl dataBase) {
        this.dataBase = dataBase;
    }

    public void insertState(State S)
    {
        //Auxiliaries
        String sql = "INSERT INTO `bootcamp2`.`state` (`country_id`,`name`, `area`, `capital`, `abbrev`) VALUES ("+S.getCountry_id()+", '"+S.getName()+"', "+S.getArea()+", '"+S.getCapital()+"', '"+S.getAbbrev()+"');";
        Connection conn=null;
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
    public State getState(String name)
    {
        //Auxiliaries
        String sql="SELECT * FROM bootcamp2.state WHERE name='"+name+"'";
        Connection conn;
        PreparedStatement ps;
        State S;
        try {
            conn = dataBase.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while(res.next())
            {
                S = new State(res.getInt("country_id"),res.getString("name"), res.getLong("area"), res.getString("capital"), res.getString("abbrev"));
                S.setId_state(res.getInt("id_state"));
                return S;
            }

        }catch (Exception E)
        {
            E.printStackTrace();
        }
        return null;
    }
}
