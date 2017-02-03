package com.bootcamp.java.adapter.state;



import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by facun on 02/02/2017.
 */
public class AdapterState {
    @JsonProperty("result")
    private List<StateJson> result;
    @JsonProperty("messages")
    private List<String> messages;

    public AdapterState(){}
    public AdapterState(List<StateJson> result) {
        this.result = result;
    }

    public List<StateJson> getResult() {
        return result;
    }

    public void setResult(List<StateJson> result) {
        this.result = result;
    }
}
