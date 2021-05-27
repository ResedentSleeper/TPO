package edu.math.baseFunctions;


public class Ln extends Function{

    public Ln() {
    }

    @Override
    public double calculate(double xValue) throws IllegalArgumentException{
        int num = 100000;
        double result = 0;

        if (xValue <= 0)
            throw new IllegalArgumentException();

        for (int i = 1; i < num; ++i)
            result += getSolveFromSeries(xValue, i);

        return 2 * result;
    }

    private double getSolveFromSeries(double xValue, int n) {
        return Math.pow((xValue - 1) / (xValue + 1), 2 * n - 1) / (2 * n - 1);
    }

}