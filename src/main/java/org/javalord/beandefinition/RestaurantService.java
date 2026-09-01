package org.javalord.beandefinition;

//@Component
public class RestaurantService {

    private Cook cook;

    public RestaurantService(Cook cook) {
        this.cook = cook;
    }

    public void makeOrder(String order) {
        System.out.println("Got order " + order);
        cook.cook();
    }

}
