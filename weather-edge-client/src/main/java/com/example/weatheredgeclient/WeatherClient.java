package com.example.weatheredgeclient;

import com.hire.weather.service.WeatherForecast;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("weather-forecast-app")
public interface WeatherClient {
    @RequestMapping(method = RequestMethod.GET, value = "/weather/weekly/{city}")
    WeatherForecast forecast(@PathVariable("city") String city);

    @RequestMapping(method = RequestMethod.GET, value = "/weather/")
    List getCities();
}
