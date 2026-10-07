package org.javalord.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantService {

    SlowCook slowCook;
    String str;

    public RestaurantService() {
    }

    @Autowired
    public RestaurantService(SlowCook slowCook) {
        this.slowCook = slowCook;
    }

    @Autowired
    public RestaurantService(String str) {
        this.str = str;
    }

    public void makeOrder(String order) {
        System.out.println("Got order " + order);

        slowCook.cook();
    }
}
