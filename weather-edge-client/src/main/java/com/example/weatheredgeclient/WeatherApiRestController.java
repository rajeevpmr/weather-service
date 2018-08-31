package com.example.weatheredgeclient;

import com.hire.weather.service.WeatherEntry;
import com.hire.weather.service.WeatherForecast;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.WatchEvent;

@RestController
public class WeatherApiRestController {

    private final WeatherClient client;

    @Autowired
    public WeatherApiRestController(WeatherClient client){
        this.client = client;
    }

   /* @RequestMapping(method = RequestMethod.GET, value = "/forecast/{city}")
    String forecast(@PathVariable String city) {
        StringBuilder builder = new StringBuilder();
         this.client.forecast(city).getEntries().forEach(weatherEntry ->
                builder.append(weatherEntry.getTemperature()));
         return builder.toString();
    }*/

   public String fallback(String city) {
        return "I guess I am in trouble!";
    }

   @HystrixCommand(fallbackMethod = "fallback")
   @RequestMapping(method = RequestMethod.GET, value = "/forecast/{city}")
   WeatherForecast forecast(@PathVariable String city){
       return this.client.forecast(city);
   }
}
