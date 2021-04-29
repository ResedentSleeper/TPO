package edu.sin;

import java.util.stream.IntStream;
import static java.lang.Double.NaN;
import static java.lang.Math.pow;

public class SinFunction {

    public SinFunction() {
    }

    /**
     * Calculate sin with set accuracy
     * By default accuracy = 0.01
     **/
    public double calculateSin(double xValue) throws IllegalArgumentException{
        int n = 0;
        double result = 0, answer = 0, tmpAnswer;

        if (checkLimits(xValue)) {
            double accuracy = 0.01;
            do {
                n++;
                tmpAnswer = answer;
                answer = getSolveFromTaylor(xValue, n);
                result += answer;
            } while (Math.abs(tmpAnswer - answer) > accuracy);
        }
        if(result == NaN || !checkLimits(xValue))
            throw new IllegalArgumentException("You can't use this argument in sin function") ;
        else
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

    /**
     * Checking limits for sin function
     **/
    private boolean checkLimits(double xValue) {
        return !(xValue > Math.PI) && !(xValue < -Math.PI);
    }

}