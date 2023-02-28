package pl.mateuszstefanski.weatherapidemo.webclient.dto;

import lombok.Getter;

@Getter
public class OpenWeatherWeatherDto {

    private OpenWeatherMainDto main;
    private OpenWeatherWindDto wind;
    private OpenWeatherStatusDto status;

}
