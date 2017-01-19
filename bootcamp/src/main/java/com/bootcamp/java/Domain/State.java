package com.bootcamp.java.Domain;

import com.bootcamp.java.Configuration.DataBase;

import java.sql.ResultSet;

/**
 * Created by facun on 16/01/2017.
 */
public class State {

        private int id_state;
        private int country_id;
        private String name;
        private long area;
        private String capital;
        private String abbrev;

        public State(){}
    public State(int country_id, String name, long area, String capital, String abbrev) {
        id_state = getLastID()+1;
        this.country_id = country_id;
        this.name = name;
        this.area = area;
        this.capital = capital;
        this.abbrev = abbrev;
    }

    public int getId_state() {
        return id_state;
    }

    public void setId_state(int id_state) {
        this.id_state = id_state;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }


    private int getLastID()
    {
        DataBase DB = DataBase.getInstance();
        String sql = "SELECT id_state FROM bootcamp2.state";
        ResultSet result = DB.DBRequest(sql);
        boolean flag;
        int mayor=0;
        try {
            while(result.next())
            {
                if (flag=false)
                {
                    mayor = result.getInt("id_state");
                    flag = true;
                }
                if (result.getInt("id_state")>mayor)
                {
                    mayor = result.getInt("id_state");
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
        return "State{" +
                "id_state=" + id_state +
                ", country_id=" + country_id +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", capital='" + capital + '\'' +
                ", abbrev='" + abbrev + '\'' +
                '}';
    }
}
