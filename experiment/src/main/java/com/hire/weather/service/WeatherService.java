package com.hire.weather.service;

import com.hire.weather.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

@Service
public class WeatherService {

    private static final String FORECAST_URL =
            "http://api.openweathermap.org/data/2.5/forecast?q={city}&APPID={key}";

    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    private final RestTemplate restTemplate;

    private final String apiKey;

    public WeatherService(RestTemplateBuilder builder, AppProperties properties) {

        this.restTemplate = builder.build();
        this.apiKey = properties.getApi().getKey();

    }

    public WeatherForecast getForeCast(String city){

        logger.info("Requesting forecast for {}", city);
        URI url = new UriTemplate(FORECAST_URL).expand(city, this.apiKey);
        return invoke(url, WeatherForecast.class);

    }

    private <T> T invoke(URI url, Class<T> responseType) {

        logger.info("Using url {}", url);

        RequestEntity<?> request = RequestEntity.get(url)
                .accept(MediaType.APPLICATION_JSON).build();
        ResponseEntity<T> exchange = this.restTemplate
                .exchange(request, responseType);
        return exchange.getBody();

    }
}
