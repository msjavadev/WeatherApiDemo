package pl.mateuszstefanski.weatherapidemo.model;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class WeatherDto {


    private String weather;
    private float temperature;
    private int pressure;
    private int humidity;
    private float windSpeed;

}
