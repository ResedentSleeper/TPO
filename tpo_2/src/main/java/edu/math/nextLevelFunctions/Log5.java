package edu.math.nextLevelFunctions;

import edu.math.baseFunctions.Function;
import edu.math.baseFunctions.Ln;

public class Log5  extends Function {

    private final Function ln ;

    public Log5() {
        this.ln = new Ln();
    }

    public Log5(Function ln) {
        this.ln = ln;
    }

    public double calculate(double xValue) throws IllegalArgumentException {
        System.out.println("Start solve log5");
        if (xValue <= 0)
            throw new IllegalArgumentException();
        return ln.calculate(xValue) / ln.calculate(5);
    }

}

