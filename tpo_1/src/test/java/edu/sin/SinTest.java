package edu.sin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvFileSource;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.*;

public class SinTest {

    private static final double ACCURACY = 0.01;
    private static final SinFunction mySin = new SinFunction();

    @ParameterizedTest
    @CsvFileSource(resources = "/sin.csv", numLinesToSkip = 1)
    public void testValues(String input, String expected) {
        assertEquals(mySin.calculateSin(Math.PI*Double.parseDouble(input)), Double.parseDouble(expected), ACCURACY);
    }

    @Test
    public void testIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            mySin.calculateSin(NaN);
            mySin.calculateSin(Double.NEGATIVE_INFINITY);
            mySin.calculateSin(Double.POSITIVE_INFINITY);
            mySin.calculateSin(7*Math.PI / 6);
        });
        System.out.println("Checking values that throws IllegalArgumentException");
    }
}
