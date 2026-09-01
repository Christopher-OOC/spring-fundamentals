package org.javalord.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        applicationContext.getBean(RestaurantService.class).makeOrder("pizza");
    }

}
