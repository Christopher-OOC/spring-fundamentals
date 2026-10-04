package org.javalord.bpp;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantService implements IRestaurantService {

    @Autowired
    SlowCook slowCook;

    public RestaurantService() {
    }

    @Critical(maxTime = 1000)
    public void makeOrder(String order) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Got order " + order);

        slowCook.cook();
    }

    @PostConstruct
    public void init() {
        System.out.println(this.getClass().getSimpleName() + ": init() called with @PostConstruct");
    }
}
