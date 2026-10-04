package org.javalord.bpp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SlowCook {

    public void cook() {
        System.out.println("cooking...");
    }

}
