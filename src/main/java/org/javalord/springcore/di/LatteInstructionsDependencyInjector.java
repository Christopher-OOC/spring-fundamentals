package org.javalord.springcore.di;

import org.javalord.springcore.Barista;
import org.javalord.springcore.CoffeeInstructions;
import org.javalord.springcore.LatteInstructions;

public class LatteInstructionsDependencyInjector implements CoffeeInstructionsDependencyInjector {

    @Override
    public Barista getBarista() {
        CoffeeInstructions instructions = new LatteInstructions();
        Barista barista = new Barista();
        return barista;
    }
}
