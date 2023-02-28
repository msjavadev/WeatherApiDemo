package pl.mateuszstefanski.weatherapidemo.webclient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.mateuszstefanski.weatherapidemo.model.WeatherDto;
import pl.mateuszstefanski.weatherapidemo.webclient.dto.OpenWeatherWeatherDto;

@Component
public class WeatherClient {

    private static final String WEATER_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "24cfdf0ae2515300d0957c58aebe667a";
    private RestTemplate restTemplate = new RestTemplate();


    public WeatherDto getWeatherForCity(String city) {
        OpenWeatherWeatherDto openWeatherWeatherDto = callGetMethod("weather?q={city}&appid={apiKey}&units=metric&lang=pl",
                OpenWeatherWeatherDto.class,
                city, API_KEY);
        return WeatherDto.builder()
                .temperature(openWeatherWeatherDto.getMain().getTemp())
                .pressure(openWeatherWeatherDto.getMain().getPressure())
                .humidity(openWeatherWeatherDto.getMain().getHumidity())
                .windSpeed(openWeatherWeatherDto.getWind().getSpeed())
                .build();
    }

    public String getForecast(double lat, double lon) {
        return callGetMethod("onecall?lat={lat}&lon={lon}&exclude=minutely,hourly&appid={apiKey}&units=metric&lang=pl",
                String.class,
                lat, lon, API_KEY);
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(WEATER_URL + url,
                responseType, objects);
    }

}
