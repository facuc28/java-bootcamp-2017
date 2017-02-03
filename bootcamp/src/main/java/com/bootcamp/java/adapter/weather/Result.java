package com.bootcamp.java.adapter.weather;


import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by facun on 02/02/2017.
 */
public class Result {
    @JsonProperty("channel")
    Channel channel;

   public Result(){}

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
