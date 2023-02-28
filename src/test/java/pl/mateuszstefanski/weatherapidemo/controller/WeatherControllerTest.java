package pl.mateuszstefanski.weatherapidemo.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.mateuszstefanski.weatherapidemo.service.WeatherService;
import pl.mateuszstefanski.weatherapidemo.webclient.WeatherClient;

@ContextConfiguration(classes = {WeatherController.class, WeatherService.class, WeatherClient.class})
@ExtendWith(SpringExtension.class)
class WeatherControllerTest {
    @Autowired
    private WeatherController weatherController;

    /**
     * Method under test: {@link WeatherController#getWeather(String)}
     */
    @Test
    void testGetWeather() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/weather/{city}", "U://U@[9U]:{UU?U#U",
                "Uri Vars");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(weatherController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link WeatherController#getWeather(String)}
     */
    @Test
    void testGetWeather2() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/weather/{city}", "", "Uri Vars");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(weatherController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("/static/index.html"));
    }
}

