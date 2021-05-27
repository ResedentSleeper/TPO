package edu.math.nextLevelFunctions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import stubs.baseFunctionsStubs.CosStub;
import stubs.baseFunctionsStubs.SinStub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CotTest {

    private static Cot myCot = new Cot();

    @BeforeAll
    public static void setUp() {
        myCot = new Cot(new CosStub(), new SinStub());
    }


    @DisplayName("Cot(x) test")
    @ParameterizedTest
    @CsvFileSource(resources = "/cot.csv")
    public void testCot(String input) {
        assertEquals( Math.cos(Double.parseDouble(input)) / Math.sin(Double.parseDouble(input)),
                myCot.calculate(Double.parseDouble(input)), 0.01);
    }

    @DisplayName("Invalid argument test")
    @Test
    public void testIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> {
            myCot.calculate(0.0);
            myCot.calculate(Math.PI);
            myCot.calculate(2*Math.PI);
        });
    }


}
