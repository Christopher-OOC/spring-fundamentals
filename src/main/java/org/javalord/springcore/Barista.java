package org.javalord.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Barista {

    private CoffeeInstructions instructions;

//    public Barista(CoffeeInstructions instructions) {
//        this.instructions = instructions;
//    }

    @Autowired
    public void setInstructions(CoffeeInstructions instructions) {
        this.instructions = instructions;
    }

    public void makeCoffee() {
        System.out.println("Make coffee with instructions " +  instructions.toString());
    }

}
