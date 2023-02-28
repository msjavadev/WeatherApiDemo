package pl.mateuszstefanski.weatherapidemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.mateuszstefanski.weatherapidemo.model.WeatherDto;
import pl.mateuszstefanski.weatherapidemo.service.WeatherService;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class WeatherController {

    private final WeatherService weatherService;

    @RequestMapping(value = "/weather", method = RequestMethod.GET)
    public String getAppInfo(){
        return "/static/index.html";
    }

    @RequestMapping("/index")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }


    @GetMapping("/weather/{city}")
    public WeatherDto getWeather(@PathVariable String city) {
        return weatherService.getWeather(city);
    }


}
