package com.bootcamp.java.adapter.weather;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by facun on 02/02/2017.
 */
public class Item {

    private String title;
    private float lat;
    @JsonProperty("long")
    private float longitud;
    private String link;
    private String pubDate;
    @JsonProperty("condition")
    private Condition condition;
    @JsonProperty("forecast")
    private Forecast[] forecast;
    private String description;
    @JsonIgnore
    private Guid guid;
    public Item(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }
    public Forecast[] getForecast() {
        return forecast;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setForecast(Forecast[] forecast) {
        this.forecast = forecast;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Guid getGuid() {
        return guid;
    }

    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
