package org.javalord.beanscope;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@Configuration
public class App {

    static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.javalord.beanscope");
        applicationContext.getBean(RestaurantService.class).makeOrder("pizza");
        applicationContext.getBean(RestaurantService.class).makeOrder("pasta");

        applicationContext.close();
    }

    @Bean
    public Supplier<SlowCook> cookBeanFactory() {
        return this::slowCook;
    }

    @Bean
    public SlowCook slowCook() {
        return new SlowCook();
    }
}
