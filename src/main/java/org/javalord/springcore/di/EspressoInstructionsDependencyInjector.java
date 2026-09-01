package org.javalord.springcore.di;

import org.javalord.springcore.Barista;
import org.javalord.springcore.CoffeeInstructions;
import org.javalord.springcore.EspressoInstructions;

public class EspressoInstructionsDependencyInjector implements CoffeeInstructionsDependencyInjector {

    @Override
    public Barista getBarista() {
        CoffeeInstructions instructions = new EspressoInstructions();
        Barista barista = new Barista();
        return barista;
    }
}
