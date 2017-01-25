package com.bootcamp.java.Persistence;

import com.bootcamp.java.Configuration.DataBase;
import com.bootcamp.java.Domain.City;
import com.bootcamp.java.Domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by facun on 25/01/2017.
 */
@Component
public class CountryDAO {
    @Autowired
    private static DataBase dataBase;

    public Country getCountry(String name) {
        //Auxiliaries

        Country C;
        String sql = "SELECT * FROM bootcamp2.country WHERE name='" + name + "'";
        System.out.println(dataBase);
        dataBase.connect();
        ResultSet res =  dataBase.DBRequest(sql);

        try {
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
    public static List<Country> getCountries() {
        //Auxiliaries

        Country C = null;
        String sql = "SELECT * FROM bootcamp2.country";
        List<Country> countryList = new ArrayList<Country>();
        dataBase.connect();
        ResultSet res =  dataBase.DBRequest(sql);

        try {
            while(res.next())
            {
                C = new Country(res.getString("country_code2"), res.getString("country_code3"), res.getString("name"));
                C.setId_country(res.getInt("id_country"));
                countryList.add(C);
            }

        }catch (Exception E)
        {
            E.printStackTrace();
        }

        return countryList;
    }
    public boolean insertCity(City C)
    {

        //Auxiliaries
        String sql = "INSERT INTO `bootcamp2`.`city` (`name`, `weather_id`, `state_id`) VALUES ('"+C.getName()+"', "+C.getWeather_id()+", "+C.getState_id()+");";
        dataBase.connect();
        return dataBase.DBInsert(sql);
    }
}
