package org.javalord.beanscope;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class RestaurantServiceOld implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private Cook cook;

    public RestaurantServiceOld(Cook cook) {
        this.cook = cook;
    }

    public void makeOrder(String order) {
        System.out.println("Got order " + order);
        applicationContext.getBean(Cook.class).cook();
//        cook.cook();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
