package org.javalord.beanscope;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FastCook implements Cook {
    @Override
    public void cook() {
        System.out.println("Very fast cook!");
    }
}
