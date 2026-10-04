package org.javalord.beanscope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class RestaurantService {

    @Autowired
    Supplier<SlowCook> cookBeanFactory;

    public void makeOrder(String order) {
        System.out.println("Got order " + order);

        cookBeanFactory.get().cook();
    }
}
