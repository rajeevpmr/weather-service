package com.example.weatheredgeclient;

import com.hire.weather.service.WeatherEntry;
import com.hire.weather.service.WeatherForecast;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.WatchEvent;
import java.util.List;

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

   public StringResponse fallback(String city) {
        return new StringResponse("I am in trouble!");
    }

   @CrossOrigin
   @HystrixCommand(fallbackMethod = "fallback")
   @RequestMapping(method = RequestMethod.GET, value = "/forecast/{city}", produces = "application/json")
   StringResponse forecast(@PathVariable String city){

       String returnVal = "Take a jacket, it might get cold";
       double compareTemp = 25.0;
       boolean isHot = false;
       for ( WeatherEntry entry :  this.client.forecast(city).getEntries()){

           if (entry.getTemperature() > compareTemp){
               isHot = true;
           }
       }

       if (isHot){
           returnVal = "Take your Sunscreen";
       }

       return new StringResponse(returnVal);
   }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/cities")
    List getCities(){
        return this.client.getCities();
    }


    class StringResponse {
        public StringResponse(String response) {
            this.response = response;
        }

        public String getResponse() {
            return response;
        }


        private String response;

    }
}
