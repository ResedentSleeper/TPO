package edu.math.compoundExpression;

import edu.math.baseFunctions.*;
import edu.math.nextLevelFunctions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CompoundSystemTest {

    private static CompoundSystem cSys;

    @BeforeAll
    public static void setUp() {
        cSys = new CompoundSystem(new Log5(), new Ln(),new Lg(), new Cot(), new Sec(), new Csc(), new Sin());
    }


    @DisplayName("System integration test")
    @ParameterizedTest
    @CsvFileSource(resources ="/cSys.csv")
    public void testSec(String input, String expected){
        assertEquals(cSys.systemSolve(Double.parseDouble(input)),Double.parseDouble(expected),0.001);
    }

    @DisplayName("Invalid argument test")
    @Test
    public void testSystemWithExceptions(){
        assertThrows(IllegalArgumentException.class, () -> {
            cSys.systemSolve(0.0);
            cSys.systemSolve(-Math.PI);
            cSys.systemSolve(-Math.PI/2);
        });
    }

}
