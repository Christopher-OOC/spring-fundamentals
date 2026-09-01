package org.javalord.springcore;

public class CoffeeInstructionsFactory {

    public static CoffeeInstructions create(String coffeeType) {
        if ("latte".equalsIgnoreCase(coffeeType)) return new LatteInstructions();
        if ("espresso".equalsIgnoreCase(coffeeType)) return new EspressoInstructions();

        throw new RuntimeException("Unknown coffee type " + coffeeType);
    }

}
