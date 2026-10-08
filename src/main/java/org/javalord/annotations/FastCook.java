package org.javalord.annotations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@DirtyCook
public class FastCook implements Cook {
    @Override
    public void cook() {
        System.out.println("fast cooking...");
    }
}
