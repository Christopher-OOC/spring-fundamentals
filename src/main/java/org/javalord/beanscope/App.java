package org.javalord.beanscope;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.*;

import java.util.function.Supplier;

@Configuration
public class App {

    static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.javalord.beanscope");
        applicationContext.getBeanFactory().registerScope("myScope", new MyScope());

        applicationContext.getBean(RestaurantService.class).makeOrder("pizza");
        applicationContext.getBean(RestaurantService.class).makeOrder("pasta");

        Thread.sleep(6000);

        applicationContext.getBean(RestaurantService.class).makeOrder("burrito");
        applicationContext.getBean(RestaurantService.class).makeOrder("water");

        applicationContext.close();
    }

    @Bean
    public Supplier<SlowCook> cookBeanFactory() {
        return this::slowCook;
    }

    @Bean
    @Scope(value = "myScope")
    public SlowCook slowCook() {
        return new SlowCook();
    }
}
