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

    public void makeOrder(String order) {
        System.out.println("Got order " + order);

        slowCook.cook();
    }

    @PostConstruct
    public void init() {
        System.out.println(this.getClass().getSimpleName() + ": init() called with @PostConstruct");
    }
}
