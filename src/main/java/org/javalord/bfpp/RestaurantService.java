package org.javalord.bfpp;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
@InitMethod("try")
public class RestaurantService {

    @Autowired
    SlowCook slowCook;

    @Value("my restaurant")
    private String name;

    public RestaurantService() {
    }

    public void makeOrder(String order) {
        System.out.println("Got order " + order);

        slowCook.cook();
    }

//    @PostConstruct
    public void init() {
        System.out.println(this.getClass().getSimpleName() + ": init() called with @PostConstruct");
        System.out.println("My restaurant name is " + name);
    }
}
