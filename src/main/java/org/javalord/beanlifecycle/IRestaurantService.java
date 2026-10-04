package org.javalord.beanlifecycle;

import jakarta.annotation.PostConstruct;

public interface IRestaurantService {

    @PostConstruct
    void init3();
//        System.out.println(this.getClass().getSimpleName() + ": interface called with @PostConstruct");


}
