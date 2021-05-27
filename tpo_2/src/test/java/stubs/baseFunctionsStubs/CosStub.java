package stubs.baseFunctionsStubs;

import edu.math.baseFunctions.Function;

public class CosStub extends Function {

    @Override
    public double calculate(double xValue) {
        return Math.cos(xValue);
    }

}