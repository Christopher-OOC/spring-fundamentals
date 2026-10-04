package org.javalord.beanlifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {

    static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.javalord.beanlifecycle");

        applicationContext.getBean(RestaurantService.class).makeOrder("pizza");

        applicationContext.close();
    }

    @Bean
//    @Scope(value = "prototype")
    public SlowCook slowCook() {
        return new SlowCook();
    }

    @Bean(initMethod = "init2", destroyMethod = "destroy2")
    public RestaurantService restaurantService() {
        return new RestaurantService();
    }
}
