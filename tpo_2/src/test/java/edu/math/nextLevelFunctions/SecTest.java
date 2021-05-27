package edu.math.nextLevelFunctions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import stubs.baseFunctionsStubs.CosStub;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SecTest {

    private static Sec mySec;

    @BeforeAll
    public static void setUp(){
        mySec=new Sec(new CosStub());
    }


    @DisplayName("Sec(x) test")
    @ParameterizedTest
    @CsvFileSource(resources ="/sec.csv")
    public void testSec(String input) {
        assertEquals(1/Math.cos(Double.parseDouble(input)), mySec.calculate(Double.parseDouble(input)), 0.001);
    }

    @DisplayName("Invalid argument test")
    @Test
    public void testIllegalArgumentException(){
        mySec = new Sec();
        assertThrows(IllegalArgumentException.class, () -> {
            mySec.calculate( -1.570796);
            mySec.calculate( 1.570796);
        });
    }

}
