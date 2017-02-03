package com.bootcamp.java.adapter.state;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by facun on 02/02/2017.
 */
public class RestResponseState {
    @JsonProperty("RestResponse")
    private AdapterState adapterState;

    public RestResponseState(){}
    public RestResponseState(AdapterState adapterState) {
        this.adapterState = adapterState;
    }

    public AdapterState getAdapterState() {
        return adapterState;
    }

    public void setAdapterState(AdapterState adapterState) {
        this.adapterState = adapterState;
    }
}
