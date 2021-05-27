package edu.math.nextLevelFunctions;

import edu.math.baseFunctions.Cos;
import edu.math.baseFunctions.Function;

public class Sec extends Function {

    private final Function cos;

    public Sec() {
        this.cos = new Cos();
    }

    public Sec(Function cos) {
        this.cos = cos;
    }

    @Override
    public double calculate(double xValue) throws IllegalArgumentException {
        System.out.println("Start solve sec");
        if (cos.calculate(xValue) == 0 || (cos.calculate(xValue)>-0.00001 && cos.calculate(xValue)<0.00001))
            throw new IllegalArgumentException();
        return 1 / cos.calculate(xValue);
    }
}
