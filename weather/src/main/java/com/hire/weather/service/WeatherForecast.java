package com.hire.weather.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.hire.weather.service.WeatherEntry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeatherForecast implements Serializable {

    @JsonProperty("entries")
    public List<WeatherEntry> getEntries() {
        return entries;
    }

    @JsonSetter("list")
    public void setEntries(List<WeatherEntry> entries) {
        this.entries = entries;
    }

    private List<WeatherEntry> entries = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @JsonProperty("city")
    public void setCity(Map<String, Object> city) {
        setName(city.get("name").toString());
    }

}
