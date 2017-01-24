package com.bootcamp.java.Persistence;

import com.bootcamp.java.Configuration.DataBase;
import com.bootcamp.java.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;

/**
 * Created by facun on 17/01/2017.
 */
@Component
public class DBPersistence {
    @Autowired
    private DataBase dataBase;

    public DBPersistence() {}

    public void setDataSource(DataBase dataBase)
    {
        this.dataBase = dataBase;
    }

    public boolean insertCountry(Country C)
    {
        //Auxiliaries
        String sql = "INSERT INTO `bootcamp2`.`country` (`id_country`, `country_code2`, `country_code3`, `name`) VALUES ("+C.getId_country()+", '"+C.getCountry_code2()+"'"+", '"+C.getCountry_code3()+"', '"+C.getName()+"');";
            dataBase.connect();
            return dataBase.DBInsert(sql);
    }

    public boolean insertState(State S)
    {
        //Auxiliaries
        String sql = "INSERT INTO `bootcamp2`.`state` (`country_id`, `name`, `area`, `capital`, `abbrev`) VALUES ("+S.getCountry_id()+", '"+S.getName()+"', "+S.getArea()+", '"+S.getCapital()+"', '"+S.getAbbrev()+"');";
        dataBase.connect();
        return dataBase.DBInsert(sql);
    }
    public boolean insertCity(City C)
    {

        //Auxiliaries
        String sql = "INSERT INTO `bootcamp2`.`city` (`name`, `weather_id`, `state_id`) VALUES ('"+C.getName()+"', "+C.getWeather_id()+", "+C.getState_id()+");";
        dataBase.connect();
        return dataBase.DBInsert(sql);
    }
    public boolean insertWind(Wind W)
    {
        //Auxiliaries
        String sql = "INSERT INTO `bootcamp2`.`wind` (`speed`, `direction`) VALUES ("+W.getSpeed()+", "+W.getDirection()+");";
        dataBase.connect();
        return dataBase.DBInsert(sql);
    }
    public boolean insertAtmosphere(Atmosphere A)
    {
        //Auxiliaries
        String sql = "INSERT INTO `bootcamp2`.`atmosphere` (`humidity`, `visibility`, `rising`, `pressure`) VALUES ("+A.getHumidity()+", "+A.getVisibility()+", "+A.getRising()+", "+A.getPressure()+");";
        dataBase.connect();
        return dataBase.DBInsert(sql);
    }

    public boolean insertActualWeather(Actual_weather AW)
    {
        //Auxiliaries
        String sql = "INSERT INTO `bootcamp2`.`actual_weather` (`temperature`, `description`, `date`) VALUES ("+AW.getTemperature()+", '"+AW.getDescription()+"', '"+AW.getDate()+"');";
        dataBase.connect();
        return dataBase.DBInsert(sql);
    }
    public boolean insertExtendedWeather(Extended_weather EW)
    {
        //Auxiliaries
        String sql = "INSERT INTO `bootcamp2`.`extended_weather` (`description`, `weekday`, `maximum`, `minimum`, `date`) VALUES ('"+EW.getDescription()+"', '"+EW.getWeekday()+"', '"+EW.getMaximum()+"', '"+EW.getMinimum()+"', '"+EW.getDate()+"');";
        dataBase.connect();
        return dataBase.DBInsert(sql);
    }
    public boolean insertWeather(Weather W)
    {
        //Auxiliaries
        String sql = "INSERT INTO `bootcamp2`.`weather` (`wind_id`, `atmosphere_id`, `actual_weather_id`, `extended_weather_id`, `description`) VALUES ("+W.getWind_id()+", "+W.getAtmosphere_id()+", "+W.getActual_weather_id()+", "+W.getExtended_weather_id()+", '"+W.getDescription()+"');";
        dataBase.connect();
        return dataBase.DBInsert(sql);
    }

    public Country getCountry(String name) {
        //Auxiliaries

        Country C = null;
        String sql = "SELECT * FROM bootcamp2.country WHERE name='" + name + "'";
        System.out.println(dataBase.getUserDB());
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
    public State getState(String name)
    {
        //Auxiliaries
        dataBase.connect();
        State S=null;
        String sql="SELECT * FROM bootcamp2.state WHERE name='"+name+"'";
        ResultSet res =  dataBase.DBRequest(sql);

        try {
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

    public City getCity(String name)
    {
        //Auxiliaries
        dataBase.connect();
        City C=null;
        String sql="SELECT * FROM bootcamp2.city WHERE name='"+name+"'";
        ResultSet res =  dataBase.DBRequest(sql);
        try {
            while(res.next())
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
    }
    public Wind getWind(int id_wind){

        //Auxiliaries
        dataBase.connect();
        Wind W = null;
        String sql="SELECT * FROM bootcamp2.wind WHERE id_wind="+id_wind;
        ResultSet res =  dataBase.DBRequest(sql);
        try {
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

    public Atmosphere getAtmosphere(int id_atmosphere)
    {
        //Auxiliaries
        dataBase.connect();
        Atmosphere A= null;
        String sql="SELECT * FROM bootcamp2.atmosphere WHERE id_atmosphere="+id_atmosphere;
        ResultSet res =  dataBase.DBRequest(sql);
        try {
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

    public Actual_weather getActualWeather(int id_actualWeather)
    {
        //Auxiliares
        Actual_weather AW;
        String sql="SELECT * FROM bootcamp2.actual_weather WHERE id_actualWeather="+id_actualWeather;
        ResultSet res =  dataBase.DBRequest(sql);
        try {
            while(res.next())
            {
                AW = new Actual_weather(res.getDouble("temperature"), res.getString("description"), res.getString("date"));
                AW.setId_actualWeather(res.getInt("id_actualWeather"));
                return AW;
            }

        }catch (Exception E)
        {
            E.printStackTrace();
        }
        return null;

    }

    public Extended_weather getExtendedWeather(int id_extendedWeather)
    {
        //Auxiliaries
        Extended_weather EW = null;
        String sql="SELECT * FROM bootcamp2.extended_weather WHERE id_extended_weather="+id_extendedWeather;
        ResultSet res =  dataBase.DBRequest(sql);
        try {
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

    public Weather getWeather(int id_weather)
    {
        //Auxiliaries
        Weather W = null;
        String sql="SELECT * FROM bootcamp2.weather WHERE id_weather="+id_weather;
        ResultSet res =  dataBase.DBRequest(sql);
        try {
            while(res.next())
            {
                W = new Weather(res.getInt("wind_id"),res.getInt("atmosphere_id"), res.getInt("actual_weather_id"), res.getInt("extended_weather_id"), res.getString("description"));
                W.setId_weather(res.getInt("id_weather"));
                return W;
            }

        }catch (Exception E)
        {
            E.printStackTrace();
        }
        return null;
    }

    public int getLastID(String id_name, String entity)
    {
        String sql = "SELECT "+id_name+" FROM bootcamp2."+entity;
        ResultSet result = dataBase.DBRequest(sql);
        boolean flag;
        int mayor=0;
        try {
            while(result.next())
            {
                if (flag=false)
                {
                    mayor = result.getInt(id_name);
                    flag = true;
                }
                if (result.getInt(id_name)>mayor)
                {
                    mayor = result.getInt(id_name);
                }
            }
        }catch (Exception E)
        {
            E.printStackTrace();
        }
        return mayor;
    }
}
