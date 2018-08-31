package com.hire.weather.controller;

import com.hire.weather.AppProperties;
import com.hire.weather.service.WeatherForecast;
import com.hire.weather.service.WeatherService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherApiController {

    private final WeatherService service;
    private AppProperties properties;

    public WeatherApiController(WeatherService service, AppProperties properties){
        this.service = service;
        this.properties = properties;
    }

    @RequestMapping("/weekly/{city}")
    public WeatherForecast getWeatherForecast(@PathVariable String city) {

        return this.service.getForeCast(city);
    }

    @RequestMapping("/")
    public List<String> getCities(){

        return properties.getCities();

    }

}
