package edu.math.baseFunctions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LnTest {

    private static final Ln myLn = new Ln();


    public static Stream<Double> getDataSet() {
        return Stream.of(
                Math.pow(Math.E, -5),
                Math.pow(Math.E, -1),
                Math.sqrt(Math.E),
                Math.E,
                Math.pow(Math.E, 2.5),
                Math.pow(Math.E, 4));
    }

    @DisplayName("ln(x) test ")
    @ParameterizedTest
    @MethodSource("getDataSet")
    public void testLn(double arg) {
        assertEquals(Math.log(arg), myLn.calculate(arg), 0.01);
    }


    @DisplayName("Invalid argument test")
    @Test
    public void testCscWithExceptions(){
        assertThrows(IllegalArgumentException.class, () -> {
            myLn.calculate(0);
            myLn.calculate(-0.1);
            myLn.calculate(-10);
        });
    }
}
