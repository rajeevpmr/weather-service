package com.example.weatheredgeclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
@EnableZuulProxy
@EnableFeignClients
@EnableDiscoveryClient
public class WeatherEdgeClientApplication {

    @Bean
    @LoadBalanced
    RestTemplate restTempalate(){
        return new RestTemplate();
    }

	public static void main(String[] args) {
		SpringApplication.run(WeatherEdgeClientApplication.class, args);
	}
}

