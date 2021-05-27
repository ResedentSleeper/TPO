package edu.math.nextLevelFunctions;

import edu.math.baseFunctions.Function;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import stubs.baseFunctionsStubs.LnStub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LgTest {

    private static Function lg = new Lg();

    @BeforeAll
    public static void setUp() {
        lg = new Lg(new LnStub());
    }


    @DisplayName("Lg(x) test")
    @ParameterizedTest
    @CsvFileSource(resources = "/lg.csv")
    public void testLg(String input) {
        assertEquals(Math.log(Double.parseDouble(input)) / Math.log(10), lg.calculate(Double.parseDouble(input)), 0.001);
    }

    @Test
    @DisplayName("Invalid argument test")
    public void testIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            lg.calculate(0);
            lg.calculate(-0.1);
            lg.calculate(-10);
        });
    }

}
