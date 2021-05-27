package stubs.baseFunctionsStubs;

import edu.math.baseFunctions.Function;

public class LnStub extends Function {

    @Override
    public double calculate(double xValue) throws IllegalArgumentException{
        if(xValue == 0)
            throw new IllegalArgumentException();
        return Math.log(xValue);
    }
}
