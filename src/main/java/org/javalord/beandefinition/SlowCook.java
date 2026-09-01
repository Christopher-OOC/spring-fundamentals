package org.javalord.beandefinition;

import org.springframework.stereotype.Component;

@Component
public class SlowCook implements Cook {
    @Override
    public void cook() {
        System.out.println("Very slow cook!");
    }
}
