package edu.math.baseFunctions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinTest {

    private static final Sin mySin = new Sin();


    @DisplayName("Sin(x) test")
    @ParameterizedTest
    @CsvFileSource(resources ="/sin.csv")
    public void testSin(String input, String expected) {
        assertEquals(mySin.calculate(Math.PI * Double.parseDouble(input)), Double.parseDouble(expected), 0.01);
    }

    @DisplayName(value = "Invalid argument test")
    @Test
    public void testIllegalArgumentException() {
        assertEquals(mySin.calculate(NaN), NaN);
        assertEquals(mySin.calculate(Double.NEGATIVE_INFINITY), NaN);
        assertEquals(mySin.calculate(Double.POSITIVE_INFINITY), NaN);
    }
}
