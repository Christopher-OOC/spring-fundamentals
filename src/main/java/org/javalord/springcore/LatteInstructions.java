package org.javalord.springcore;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class LatteInstructions implements CoffeeInstructions {

    @Override
    public String toString() {
        return "milk,coffee [latte]";
    }

}
