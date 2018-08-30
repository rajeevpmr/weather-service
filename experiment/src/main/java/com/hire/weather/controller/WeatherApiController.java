package com.hire.weather.controller;

import com.hire.weather.service.WeatherForecast;
import com.hire.weather.service.WeatherService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherApiController {

    private final WeatherService service;

    public WeatherApiController(WeatherService service){
        this.service = service;
    }

    @RequestMapping("/weekly/{city}")
    public WeatherForecast getWeatherForecast(@PathVariable String city) {

        return this.service.getForeCast(city);
    }

}
