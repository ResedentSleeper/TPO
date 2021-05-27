package edu.math.nextLevelFunctions;

import edu.math.baseFunctions.Function;
import edu.math.baseFunctions.Ln;

public class Lg extends Function {

    private final Function ln;

    public Lg() {
        this.ln = new Ln();
    }

    public Lg(Function ln) {
        this.ln = ln;
    }

    @Override
    public double calculate(double xValue) throws IllegalArgumentException {
        System.out.println("Start solve lg");
        if (xValue <= 0)
            throw new IllegalArgumentException();
        return ln.calculate(xValue) / ln.calculate(10);
    }

}
