package org.javalord.springcontainer;

public class SlowCook implements Cook {
    @Override
    public void cook() {
        System.out.println("Very slow cook!");
    }
}
