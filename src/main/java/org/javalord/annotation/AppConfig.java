package org.javalord.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RestaurantService restaurantService() {
        return new RestaurantService(cook());
    }

    @Bean
    public Cook cook() {
        return new SlowCook();
    }

}
