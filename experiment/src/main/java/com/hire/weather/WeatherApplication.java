package com.hire.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class WeatherApplication {

	public static void main(String[] args) {

		SpringApplication.run(WeatherApplication.class, args);
	}
}
