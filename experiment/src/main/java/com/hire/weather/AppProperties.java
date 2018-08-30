package com.hire.weather;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.List;

@ConfigurationProperties("app.weather")
public class AppProperties {

    public Api getApi() {
        return this.api;
    }

    private final Api api = new Api();

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    private List<String> cities = Arrays.asList("London", "Toronto", "Moscow");


    public static class Api {

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        private String key;

    }
}
