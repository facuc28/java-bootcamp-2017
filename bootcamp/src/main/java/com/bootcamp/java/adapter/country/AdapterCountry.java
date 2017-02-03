package com.bootcamp.java.adapter.country;


import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by facun on 01/02/2017.
 */

public class AdapterCountry {
    @JsonProperty("result")
    private List<CountryJson> result;
    @JsonProperty("messages")
    private List<String> messages;

    public List<CountryJson> getListOfCounties() {
        return result;
    }

    public void setListOfCounties(List<CountryJson> listOfCounties) {
        this.result = listOfCounties;
    }
}
