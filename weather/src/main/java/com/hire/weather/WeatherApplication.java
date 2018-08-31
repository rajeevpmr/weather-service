package com.hire.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
@EnableEurekaClient
public class WeatherApplication {

	public static void main(String[] args) {

		SpringApplication.run(WeatherApplication.class, args);
	}
}
