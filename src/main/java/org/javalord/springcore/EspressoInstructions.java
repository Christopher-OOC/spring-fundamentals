package org.javalord.springcore;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class EspressoInstructions implements CoffeeInstructions {

    @Override
    public String toString() {
        return "milk,more coffee [espresso]";
    }

}
