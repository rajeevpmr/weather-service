package com.hire.weather;

import com.hire.weather.service.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(WeatherService.class)
@TestPropertySource(properties = "app.weather.api.key=test-key")
public class WeatherServiceTest {

    private static final String URL = "http://api.openweathermap.org/data/2.5/";

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private MockRestServiceServer server;

    @Test
    public void getWeatherForecast() {

        this.server.expect(
                requestTo(URL + "forecast?q=tokyo&APPID=test-key"))
                .andRespond(withSuccess(
                        new ClassPathResource("forecast-tokyo.json", getClass()),
                        MediaType.APPLICATION_JSON));
        this.weatherService.getForeCast("tokyo");
        this.server.verify();
    }
}
