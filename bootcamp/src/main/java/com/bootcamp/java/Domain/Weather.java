package com.bootcamp.java.Domain;

import com.bootcamp.java.Builder.WeatherBuilder;

/**
 * Created by facun on 16/01/2017.
 */
public class Weather {

        private int id_weather;
        private int wind_id;
        private int atmosphere_id;
        private int actual_weather_id;
        private int extended_weather_id;
        private String description;

        public  Weather(){}

    public Weather(int wind_id, int atmosphere_id, int actual_weather_id, int extended_weather_id, String description) {

        this.wind_id = wind_id;
        this.atmosphere_id = atmosphere_id;
        this.actual_weather_id = actual_weather_id;
        this.extended_weather_id = extended_weather_id;
        this.description = description;
    }

    public Weather(WeatherBuilder builder)
    {
        this.wind_id = builder.wind_id;
        this.atmosphere_id = builder.atmosphere_id;
        this.actual_weather_id = builder.actual_weather_id;
        this.extended_weather_id = builder.extended_weather_id;
        this.description = builder.description;
    }
    public int getId_weather() {
        return id_weather;
    }

    public void setId_weather(int id_weather) {
        this.id_weather = id_weather;
    }

    public int getWind_id() {
        return wind_id;
    }

    public void setWind_id(int wind_id) {
        this.wind_id = wind_id;
    }

    public int getAtmosphere_id() {
        return atmosphere_id;
    }

    public void setAtmosphere_id(int atmosphere_id) {
        this.atmosphere_id = atmosphere_id;
    }

    public int getActual_weather_id() {
        return actual_weather_id;
    }

    public void setActual_weather_id(int actual_weather_id) {
        this.actual_weather_id = actual_weather_id;
    }

    public int getExtended_weather_id() {
        return extended_weather_id;
    }

    public void setExtended_weather_id(int extended_weather_id) {
        this.extended_weather_id = extended_weather_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
/*
    private int getLastID()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataBase DB = applicationContext.getBean("dataBase", DataBase.class);
        String sql = "SELECT id_weather FROM bootcamp2.weather";
        ResultSet result = DB.DBRequest(sql);
        boolean flag;
        int mayor=0;
        try {
            while(result.next())
            {
                if (flag=false)
                {
                    mayor = result.getInt("id_weather");
                    flag = true;
                }
                if (result.getInt("id_weather")>mayor)
                {
                    mayor = result.getInt("id_weather");
                }
            }
        }catch (Exception E)
        {
            E.printStackTrace();
        }
        return mayor;
    }
    */

    /*
    public String toString() {
            //auxiliaries
        DBPersistence persistence = new DBPersistence();
        return "Weather information: {" + description +
                "\n Wind Information= " + persistence.getWind(wind_id).toString() +
                "\n Atmosphere Information: " + persistence.getAtmosphere(atmosphere_id).toString() +
                "\n Actual Weather: " + persistence.getActualWeather(actual_weather_id).toString() +
                "\n Extended Weather: " + persistence.getExtendedWeather(extended_weather_id).toString() +
                ", description='" + description + '\'' +
                '}';
    }
    */
}
