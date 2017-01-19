package com.bootcamp.java.Domain;

import com.bootcamp.java.Builder.CountryBuilder;
import com.bootcamp.java.Configuration.DataBase;

import java.sql.ResultSet;

/**
 * Created by facun on 16/01/2017.
 */
public class Country {
    private  int id_country;
    private String country_code2;
    private String country_code3;
    private String name;

    public Country(){}
    public Country(CountryBuilder builder)
    {
        this.country_code2 = builder.country_code2;
        this.country_code3 = builder.country_code3;
        this.name = builder.name;

    }
    public Country(String country_code2, String country_code3, String name) {
        id_country = getLastID()+1;
        this.country_code2 = country_code2;
        this.country_code3 = country_code3;
        this.name = name;
    }

    public int getId_country() {
        return id_country;
    }

    public void setId_country(int id_country) {
        this.id_country = id_country;
    }

    public String getCountry_code2() {
        return country_code2;
    }

    public void setCountry_code2(String country_code2) {
        this.country_code2 = country_code2;
    }

    public String getCountry_code3() {
        return country_code3;
    }

    public void setCountry_code3(String country_code3) {
        this.country_code3 = country_code3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private int getLastID()
    {
        DataBase DB = DataBase.getInstance();
        String sql = "SELECT id_country FROM bootcamp2.country";
        ResultSet result = DB.DBRequest(sql);
        boolean flag;
        int mayor=0;
        try {
            while(result.next())
            {
                if (flag=false)
                {
                    mayor = result.getInt("id_country");
                    flag = true;
                }
                if (result.getInt("id_country")>mayor)
                {
                    mayor = result.getInt("id_country");
                }
            }
        }catch (Exception E)
        {
            E.printStackTrace();
        }
        return mayor;
    }
    @Override
    public String toString() {
        return "Country{" +
                "id_country=" + id_country +
                ", country_code2='" + country_code2 + '\'' +
                ", country_code3='" + country_code3 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
