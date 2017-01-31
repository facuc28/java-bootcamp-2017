package com.bootcamp.java.Persistence;


import com.bootcamp.java.Configuration.DataBaseImpl;
import com.bootcamp.java.Domain.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by facun on 25/01/2017.
 */

public class CountryDAO {

    private DataBaseImpl dataBase;

    public void setDataBase(DataBaseImpl dataBase) {
        this.dataBase = dataBase;
    }
/*
    public Country getCountry(String name) {
            //Auxiliaries

            Country C;
            String sql = "SELECT * FROM bootcamp2.country WHERE name='" + name + "'";
            PreparedStatement ps = null;
            Connection conn = null;
            try {
                conn = dataBase.getConnection();
                ps = conn.prepareStatement(sql);
                ResultSet res = ps.executeQuery();
                while(res.next())
                {
                    C = new Country(res.getString("country_code2"), res.getString("country_code3"), res.getString("name"));
                    C.setId_country(res.getInt("id_country"));
                    return  C;
                }

            }catch (Exception E)
            {
                E.printStackTrace();
            }

            return null;
        }
    public  List<Country> getCountries() {
        //Auxiliaries
        String sql = "SELECT * FROM bootcamp2.country";
        PreparedStatement ps=null;
        Connection conn = null;
        List<Country> countryList = new ArrayList<Country>();
        try {
            conn = dataBase.getConnection();
            ps = conn.prepareStatement(sql);
            Country C = null;
            ResultSet res = ps.executeQuery();
            while(res.next())
                C = new Country(res.getString("country_code2"), res.getString("country_code3"), res.getString("name"));
                countryList.add(C);

        }catch (Exception E)
        {
            E.printStackTrace();
        }

        return countryList;
    }

    public void insertCountry(Country C)
    {
        //Auxiliaries
        String sql = "INSERT INTO `bootcamp2`.`country` (`country_code2`, `country_code3`, `name`) VALUES ('"+C.getCountryCode2()+"'"+", '"+C.getCountryCode3()+"', '"+C.getName()+"');";
        Connection conn = null;
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
*/
}
