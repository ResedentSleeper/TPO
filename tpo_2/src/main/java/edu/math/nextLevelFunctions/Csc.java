package edu.math.nextLevelFunctions;

import edu.math.baseFunctions.Function;
import edu.math.baseFunctions.Sin;


public class Csc extends Function {

    private final Function sin;

    public Csc() {
        this.sin = new Sin();
    }

    public Csc(Function sin) {
        this.sin = sin;
    }

    @Override
    public double calculate(double xValue) throws IllegalArgumentException {
        System.out.println("Start solve csc");
        if (sin.calculate(xValue) == 0)
            throw new IllegalArgumentException();
        return 1 / sin.calculate(xValue);
    }
}