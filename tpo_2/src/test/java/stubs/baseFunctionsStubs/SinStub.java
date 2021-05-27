package stubs.baseFunctionsStubs;

import edu.math.baseFunctions.Function;

public class SinStub extends Function {

    @Override
    public double calculate(double xValue) {
        return Math.sin(xValue);
    }

}
