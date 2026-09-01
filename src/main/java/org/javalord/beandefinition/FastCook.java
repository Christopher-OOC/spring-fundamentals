package org.javalord.beandefinition;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FastCook implements Cook {
    @Override
    public void cook() {
        System.out.println("Very fast cook!");
    }
}
