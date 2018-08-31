package com.hire.weather.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public class WeatherEntry implements Serializable {

    private Instant timestamp;
    private double temperature;
    private Integer weatherId;
    private String weatherIcon;

    @JsonProperty("timestamp")
    public Instant getTimestamp() {
        return timestamp;
    }

    @JsonSetter("dt")
    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

   /* public Integer getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(Integer weatherId) {
        this.weatherId = weatherId;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    } */

    @JsonProperty("main")
    public void setMain(Map<String, Object> main) {
        System.out.println("Temperature from API :: " + main.get("temp").toString());
        double celsiusTemp = Double.parseDouble(main.get("temp").toString()) - 273.15;
        System.out.println("Celcius temperature :: " + celsiusTemp);
        setTemperature(celsiusTemp);
    }

    /*@JsonProperty("weather")
    public void setWeather(List<Map<String, Object>> weatherEntries) {
        Map<String, Object> weather = weatherEntries.get(0);
        setWeatherId((Integer) weather.get("id"));
        setWeatherIcon((String) weather.get("icon"));
    } */
}
