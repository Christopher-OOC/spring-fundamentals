package org.javalord.beanscope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class RestaurantService {

    private Cook cook;

    public RestaurantService(Cook cook) {
        this.cook = cook;
    }

    public void makeOrder(String order) {
        System.out.println("Got order " + order);
        cook.cook();
//        cook.cook();
    }

//    @Lookup
//    protected abstract Cook getCook();
}
