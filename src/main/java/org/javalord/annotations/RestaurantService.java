package org.javalord.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RestaurantService {

    @Autowired
    @DirtyCook
    Cook cook;
    //String str;

////    @Autowired
//    public RestaurantService(String str) {
//        this.str = str;
//    }

//    @Autowired(required = false)
//    public void setSlowCook(SlowCook slowCook) {
//        System.out.println("slow cook1");
//        this.slowCook = slowCook;
//    }
//
//    @Autowired
//    public void setSlowCook2(@Nullable SlowCook slowCook) {
//        System.out.println("slow cook2");
//        this.slowCook = slowCook;
//    }

    public void makeOrder(String order) {
        System.out.println("Got order " + order);

        cook.cook();
    }
}
