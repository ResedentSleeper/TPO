package edu.math.nextLevelFunctions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import stubs.baseFunctionsStubs.SinStub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CscTest {

    private static Csc myCsc = new Csc();

    @BeforeAll
    public static void setUp(){
        myCsc=new Csc(new SinStub());
    }


    @DisplayName("Csc(x) test")
    @ParameterizedTest
    @CsvFileSource(resources ="/csc.csv")
    public void testCsc(String input) {
        assertEquals(1/Math.sin(Double.parseDouble(input)), myCsc.calculate(Double.parseDouble(input)), 0.01);
    }

    @DisplayName("Invalid argument test")
    @Test
    public void testIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> {
            myCsc.calculate(0.0);
            myCsc.calculate(Math.PI);
            myCsc.calculate(-Math.PI);
            myCsc.calculate(2*Math.PI);
        });
    }

}
