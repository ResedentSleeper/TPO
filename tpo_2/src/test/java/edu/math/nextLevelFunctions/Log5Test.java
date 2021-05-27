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

public class Log5Test {

    private static Function ln5 = new Log5();

    @BeforeAll
    public static void setUp() {
        ln5 = new Log5(new LnStub());
    }


    @DisplayName("Log5(x) test")
    @ParameterizedTest
    @CsvFileSource(resources ="/log5.csv")
    public void testLog5(String input)  {
        assertEquals(Math.log(Double.parseDouble(input)) / Math.log(5), ln5.calculate(Double.parseDouble(input)), 0.001);
    }

    @DisplayName("Invalid argument test")
    @Test
    public void testIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> {
            ln5.calculate(0);
            ln5.calculate(-0.1);
            ln5.calculate(-5);
        });
    }
}
