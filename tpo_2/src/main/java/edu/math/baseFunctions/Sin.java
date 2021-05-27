package edu.math.baseFunctions;

import java.util.stream.IntStream;

import static java.lang.Math.pow;

public class Sin extends Function{

    public Sin() {
    }


    /**
     * Calculate sin with set accuracy
     * By default accuracy = 0.01
     **/
    @Override
    public double calculate(double xValue) {
        int n = 0;
        double result = 0, answer = 0, tmpAnswer;

        double accuracy = 0.01;
        do {
            n++;
            tmpAnswer = answer;
            answer = getSolveFromTaylor(xValue, n);
            result += answer;
        } while (Math.abs(tmpAnswer - answer) > accuracy);

        return result;
    }

    /**
     * Calculate factorial for Taylor series
     **/
    private int factorialUsingStreams(int n) {
        return IntStream.rangeClosed(1, n).reduce(1, (int x, int y) -> x * y);
    }

    /**
     * Calculate Taylor series
     **/
    private double getSolveFromTaylor(double xValue, int n) {
        return pow(-1, (n - 1)) * pow(xValue, (2 * n - 1)) / factorialUsingStreams(2 * n - 1);
    }


}