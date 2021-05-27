package edu.math.baseFunctions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosTest {

    private static final Cos myCos = new Cos();


    @DisplayName("Cos(x) test ")
    @ParameterizedTest
    @CsvFileSource(resources ="/cos.csv")
    public void testCos(String input, String expected) {
        assertEquals(myCos.calculate(Math.PI*Double.parseDouble(input)), Double.parseDouble(expected), 0.01);
    }

    @DisplayName("Invalid argument test")
    @Test
    public void testIllegalArgumentException() {
        assertEquals(myCos.calculate(NaN), NaN);
        assertEquals( myCos.calculate(Double.NEGATIVE_INFINITY), NaN);
        assertEquals(myCos.calculate(Double.POSITIVE_INFINITY), NaN);
    }

}
