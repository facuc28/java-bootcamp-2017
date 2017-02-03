package com.bootcamp.java.proxy;

import com.bootcamp.java.Builder.*;
import com.bootcamp.java.Domain.*;
import com.bootcamp.java.adapter.country.CountryJson;
import com.bootcamp.java.adapter.country.RestResponse;
import com.bootcamp.java.adapter.state.RestResponseState;
import com.bootcamp.java.adapter.state.StateJson;
import com.bootcamp.java.adapter.weather.*;
import com.bootcamp.java.adapter.weather.Atmosphere;
import com.bootcamp.java.adapter.weather.Wind;
import com.bootcamp.java.repository.*;
import com.bootcamp.java.service.CountryWService;
import com.bootcamp.java.service.WeatherWService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by facun on 01/02/2017.
 */
@Component
public class Proxy {
    @Resource
    CountryWService countryWService;
    @Autowired
    CountryRepository countryRepository;
    @Resource
    WeatherWService weatherWService;
    @Autowired
    StateRepository stateRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    AtmosphereRepository atmosphereRepository;
    @Autowired
    WindRepository windRepository;
    @Autowired
    WeatherRepository weatherRepository;
    @Autowired
    ActualWeatherRepository actualWeatherRepository;
    @Autowired
    ExtendedWeatherRepository extendedWeatherRepository;
    public Proxy(){}

    public List<Country> getCountries(){
        List<Country> listOfCountries = new ArrayList<>();
        RestResponse restResponse = countryWService.getCountries();
        Country C=null;
        for (CountryJson CJ: restResponse.getAdapterCountry().getListOfCounties())
        {
            C = new Country(CJ.getAlpha2_code(), CJ.getAlpha3_code(), CJ.getName());
            listOfCountries.add(C);
        }
        return listOfCountries;
    }

    public List<State> getStates(String country){
        List<State> listOfStates = new ArrayList<>();
        RestResponseState restResponse = countryWService.getStates(country);
            State state;
            for (StateJson SJ: restResponse.getAdapterState().getResult())
            {
                state = new StateBuilder()
                        .countryCode3(SJ.getCountry())
                        .name(SJ.getName())
                        .abbrev(SJ.getAbbr())
                        .area(getAreaClean(SJ.getArea()))
                        .capital(SJ.getCapital())
                        .build();
                listOfStates.add(state);

        }
        return listOfStates;
    }
    public WeatherDetail getWeather(String state, String city)
    {
        //Adapters objects
        String q="select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22"+city+"%2C%20"+state+"%22)";
        String format="json";
        String env="store://datatables.org/alltableswithkeys";
        RestResponseWeather restResponseWeather = weatherWService.getWeather(q,format,env);
        Query query = restResponseWeather.getQuery();
        Channel channel= query.getResults().getChannel();
        Wind windAdapter = channel.getWind();
        Atmosphere atmosphereAdapter = channel.getAtmosphere();
        Forecast[] forecastsAdapter = channel.getItem().getForecast();
        Condition condition = channel.getItem().getCondition();
        //Domain objects
        String description = channel.getDescription();
        com.bootcamp.java.Domain.Wind wind = new WindBuilder()
                .speed(windAdapter.getSpeed())
                .direction(windAdapter.getDirection())
                .build();
        com.bootcamp.java.Domain.Atmosphere atmosphere = new AtmosphereBuilder()
                .humidity(atmosphereAdapter.getHumidity())
                .pressure(atmosphereAdapter.getPressure())
                .rising(atmosphereAdapter.getRising())
                .visibility((int)atmosphereAdapter.getVisibility())
                .Build();
        Actual_weather actual_weather = new Actual_WeatherBuilder()
                .date(condition.getDate())
                .description(channel.getDescription())
                .temperature(condition.getTemp())
                .Build();
        Extended_weather extended_weather;
        Extended_weather[] forecast = new Extended_weather[10];
        for (int i=0;i<forecastsAdapter.length;i++)
        {
            extended_weather = new Extended_WeatherBuilder()
                    .date(forecastsAdapter[i].getDate())
                    .description(forecastsAdapter[i].getText())
                    .weekday(forecastsAdapter[i].getDay())
                    .maximum(forecastsAdapter[i].getHigh())
                    .minimum(forecastsAdapter[i].getLow())
                    .Build();
            forecast[i] = extended_weather;
        }
        WeatherDetail weather = new WeatherDetail(wind,atmosphere,actual_weather, forecast,description);
        return weather;
    }

    public WeatherDetail getWeatherForCity(String state, String city)
    {
        State S = stateRepository.findByName(state);
        City C = cityRepository.findByName(city);
        Weather W=null;
        WeatherDetail weatherDetail=null;
        if (C.getState().getId_state()==S.getId_state()) {
            W = weatherRepository.findByIdCity(C.getIdCity());
            com.bootcamp.java.Domain.Atmosphere atmosphere = atmosphereRepository.findOne(W.getAtmosphere().getId_atmosphere());
            com.bootcamp.java.Domain.Wind wind = windRepository.findOne(W.getWind().getId_wind());
            Actual_weather actual_weather = actualWeatherRepository.findOne(W.getActual_weather().getId_actualWeather());
            Extended_weather[] extended_weathers = new Extended_weather[10];
            List<Extended_weather> forecast = new ArrayList<>();
            extendedWeatherRepository.findAll().forEach(forecast::add);
            int i = 0;
            for (Extended_weather EW: forecast)
            {
                if (EW.getWeather().getId_weather()==W.getId_weather())
                {
                    extended_weathers[i] = EW;
                    i++;
                }
            }
             weatherDetail = new WeatherDetail(wind, atmosphere, actual_weather, extended_weathers,W.getDescription());
        }
        return weatherDetail;
    }

    private Long getAreaClean(String area)
    {
        if (area==null)
            return 0l;
        String newArea = area.substring(0,area.length()-3);
        return Long.valueOf(newArea);
    }

}
