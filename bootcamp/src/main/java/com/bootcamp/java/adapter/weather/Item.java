package com.bootcamp.java.adapter.weather;

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
    private String pubdate;
    @JsonProperty("condition")
    private Condition condition;

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

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
