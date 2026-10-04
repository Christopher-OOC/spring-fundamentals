package org.javalord.bpp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {

    static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.javalord.bpp");

        applicationContext.getBean(IRestaurantService.class).makeOrder("pizza");

        applicationContext.close();
    }
}
