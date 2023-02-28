package pl.mateuszstefanski.weatherapidemo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.mateuszstefanski.weatherapidemo.model.WeatherDto;
import pl.mateuszstefanski.weatherapidemo.webclient.WeatherClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherDto getWeather(String city) {
        return weatherClient.getWeatherForCity(city);
    }
}
