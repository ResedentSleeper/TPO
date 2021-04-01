import edu.sin.SinFunction;
import org.junit.*;
import static java.lang.Double.NaN;
import static org.junit.Assert.assertEquals;


public class SinTest {

    private static final double accuracy = 0.01;
    private double pi = Math.PI;


    @Test
    public void UpPart() {
        SinFunction mySin = new SinFunction();
        assertEquals(mySin.calculateSin( pi / 6 ), 0.5, accuracy) ;
        assertEquals(mySin.calculateSin( pi / 4), Math.sqrt(2) / 2, accuracy);
        assertEquals(mySin.calculateSin( pi/ 3), Math.sqrt(3) / 2, accuracy);
        assertEquals(mySin.calculateSin( pi/ 2), 1, accuracy);
        assertEquals(mySin.calculateSin( 2*pi/ 3), Math.sqrt(3) / 2, accuracy);
        assertEquals(mySin.calculateSin( 3*pi / 4), Math.sqrt(2) / 2, accuracy);
        assertEquals(mySin.calculateSin( 5*pi/ 6), 0.5, accuracy);
        System.out.println("Checked values from pi/6 to 5pi/6");
    }

    @Test
    public void downPart() {
        SinFunction mySin = new SinFunction();
        assertEquals(mySin.calculateSin( -pi / 6 ), -0.5, accuracy) ;
        assertEquals(mySin.calculateSin( -pi / 4), -Math.sqrt(2) / 2, accuracy);
        assertEquals(mySin.calculateSin( -pi/ 3), -Math.sqrt(3) / 2, accuracy);
        assertEquals(mySin.calculateSin( -pi/ 2), -1, accuracy);
        assertEquals(mySin.calculateSin( -2*pi / 3), -Math.sqrt(3) / 2, accuracy);
        assertEquals(mySin.calculateSin( -3* pi / 4), -Math.sqrt(2) / 2, accuracy);
        assertEquals(mySin.calculateSin( -5*pi/ 6), -0.5, accuracy);
        System.out.println("Checked values from -pi/6 to -5pi/6");
    }

    @Test
    public void zeroValues() {
        SinFunction mySin = new SinFunction();
        assertEquals(mySin.calculateSin( 0), 0, accuracy);
        assertEquals(mySin.calculateSin(pi), 0, accuracy) ;
        System.out.println("Checked values 0 and pi");
    }

    @Test
    public void prohibitedValues() {
        SinFunction mySin = new SinFunction();
        assertEquals(mySin.calculateSin(NaN), NaN, accuracy);
        assertEquals(mySin.calculateSin(Double.NEGATIVE_INFINITY) , NaN, accuracy) ;
        assertEquals(mySin.calculateSin(Double.POSITIVE_INFINITY),  NaN, accuracy);
        assertEquals(mySin.calculateSin(7*pi / 6) , NaN, accuracy) ;
        System.out.println("Checked invalid and prohibited values");
    }

    @After
    public void tearDown() {

    }
}
