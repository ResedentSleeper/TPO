package edu.math.nextLevelFunctions;


import edu.math.baseFunctions.Cos;
import edu.math.baseFunctions.Function;
import edu.math.baseFunctions.Sin;

public class Cot extends Function {

    private final Function cos ;
    private final Function sin ;

    public Cot() {
        this.cos = new Cos();
        this.sin = new Sin();
    }

    public Cot(Function cos, Function sin) {
        this.cos = cos;
        this.sin = sin;
    }

    @Override
    public double calculate(double xValue) throws IllegalArgumentException{
        System.out.println("Start solve cot");
        if (sin.calculate(xValue) == 0 || (sin.calculate(xValue)>-0.00001 && sin.calculate(xValue)<0.00001))
            throw new IllegalArgumentException();
        return cos.calculate(xValue)/sin.calculate(xValue) ;

    }

}
