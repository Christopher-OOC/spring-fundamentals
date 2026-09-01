package org.javalord.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CoffeeShop {

    static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.javalord.springcore");

        Barista barista = context.getBean(Barista.class);
        barista.makeCoffee();

    }
}
