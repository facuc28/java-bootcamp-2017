package com.bootcamp.java.adapter.weather;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by facun on 03/02/2017.
 */
public class RestResponseWeather {
    @JsonProperty("query")
    private Query query;

    public RestResponseWeather(){}
    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }
}
