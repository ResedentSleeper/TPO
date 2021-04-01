package edu.sin;

import java.util.stream.IntStream;

import static java.lang.Double.NaN;
import static java.lang.Math.pow;

public class SinFunction {

    private double accuracy = 0.01;

    public SinFunction() {
    }

    /**
     * Calculate sin with set accuracy
     * By default accuracy = 0.01
     **/
    public double calculateSin(double x_value) {
        int n = 0;
        double result = 0, answer = 0, tmpAnswer;

        if (checkLimits(x_value)) {
            do {
                n++;
                tmpAnswer = answer;
                answer = getSolveFromTaylor(x_value, n);
                result += answer;
            } while (Math.abs(tmpAnswer - answer) > accuracy);
            return result;
        }
        return NaN;
    }

    /**
     * Calculate factorial for Taylor series
     **/
    public int factorialUsingStreams(int n) {
        return IntStream.rangeClosed(1, n).reduce(1, (int x, int y) -> x * y);
    }

    /**
     * Calculate Taylor series
     **/
    private double getSolveFromTaylor(double x_value, int n) {
        return pow(-1, (n - 1)) * pow(x_value, (2 * n - 1)) / factorialUsingStreams(2 * n - 1);
    }

    /**
     * Checking limits for sin function
     **/
    private boolean checkLimits(double x_value) {
        return !(x_value > Math.PI) && !(x_value < -Math.PI);
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

}