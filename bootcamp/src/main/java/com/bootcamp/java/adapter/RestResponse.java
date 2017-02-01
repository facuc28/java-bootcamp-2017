package com.bootcamp.java.adapter;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by facun on 01/02/2017.
 */
public class RestResponse {
    @JsonProperty("RestResponse")
    private AdapterCountry adapterCountry;

    public RestResponse(){}
    public RestResponse(AdapterCountry adapterCountry) {
        this.adapterCountry = adapterCountry;
    }

    public AdapterCountry getAdapterCountry() {
        return adapterCountry;
    }

    public void setAdapterCountry(AdapterCountry adapterCountry) {
        this.adapterCountry = adapterCountry;
    }
}
