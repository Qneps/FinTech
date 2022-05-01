import junitparams.JUnitParamsRunner;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class Tests {
    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void testStandardConstructor() {
        Rational standard = new Rational();
        assertEquals("Standard constructor returns wrong numerator", 0, standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", 1, standard.getDenominator());
    }

    @Test
    @Parameters({
            "1, 2, 2, 4, 1/4",
            "1, 5, 7, 2, 7/10",
            "1, 2,-2, 4, -1/4",
            "-1, 2, -2, 4, 1/4",
    })
    public void testMultiply(int numLeft, int demLeft, int numRight, int demRight, String expectedResult) {
        Rational rationalLeft = new Rational(numLeft, demLeft);
        Rational rationalRight = new Rational(numRight, demRight);
        assertEquals("Умножить правильно не получилось", expectedResult, rationalLeft.multiply(rationalRight).toString());
    }

    @Test
    @Parameters({
            "1, 2, 2, 4, 1/1",
            "1, 5, 7, 2, 2/35",
            "1, 2,-2, 4, -1/1",
            "-1, 2, -2, 4, 1/1",
    })
    public void testDivide(int numLeft, int demLeft, int numRight, int demRight, String expectedResult) {
        Rational rational1 = new Rational(numLeft, demLeft);
        Rational rational2 = new Rational(numRight, demRight);
        assertEquals("Разделить правильно не получилось", expectedResult, rational1.divide(rational2).toString());
    }

    @Test
    public void testDivideByZero() throws ArithmeticException {
        Rational rational1 = new Rational(1, 2);
        Rational rational2 = new Rational(0, 2);
        thrown.expect(ArithmeticException.class);
        thrown.expectMessage("division by zero");
        rational1.divide(rational2);

    }

    @Test
    @Parameters({
            "1, 2, 2, 4, 1/1",
            "1, 5, 7, 2, 37/10",
            "1,2, -2, 4, 0/1",
            "-1, 2, -2, 4, -1/1"
    })
    public void testPlus(int numLeft, int demLeft, int numRight, int demRight, String expectedResult) {
        Rational rational1 = new Rational(numLeft, demLeft);
        Rational rational2 = new Rational(numRight, demRight);
        assertEquals("Сложить правильно не получилось", expectedResult, rational1.plus(rational2).toString());
    }

    @Test
    @Parameters({
            "1, 2, 2, 4, 0/1",
            "1, 5, 7, 2, -33/10",
            "1,2, -2, 4, 1/1",
            "-1, 2, -2, 4, 0/1"
    })
    public void testMinus(int numLeft, int demLeft, int numRight, int demRight, String expectedResult) {
        Rational rational1 = new Rational(numLeft, demLeft);
        Rational rational2 = new Rational(numRight, demRight);
        assertEquals("Вычесть правильно не получилось", expectedResult, rational1.minus(rational2).toString());
    }

    @Test
    @Parameters({
            "1, 2, 2, 4"
    })
    public void testEqualsTrue(int numLeft, int demLeft, int numRight, int demRight) {
        Rational rational1 = new Rational(numLeft, demLeft);
        Rational rational2 = new Rational(numRight, demRight);
        assertTrue("Сравнить дроби не получилось", rational1.equals(rational2));
    }

    @Test
    @Parameters({
            "1, 2, -2, 4"
    })
    public void testEqualsFalse(int numLeft, int demLeft, int numRight, int demRight) {
        Rational rational1 = new Rational(numLeft, demLeft);
        Rational rational2 = new Rational(numRight, demRight);
        assertFalse("Сравнить дроби не получилось", rational1.equals(rational2));
    }

    @Test
    @Parameters({
            "1, 2, 2, 4"
    })
    public void testLessFalse(int numLeft, int demLeft, int numRight, int demRight){
        Rational rational1 = new Rational(numLeft, demLeft);
        Rational rational2 = new Rational(numRight, demRight);
        assertFalse("Сравнить дроби не получилось", rational1.less(rational2));

    }

    @Test
    @Parameters({
            "-1, 2, 2, 4"
    })
    public void testLessTrue(int numLeft, int demLeft, int numRight, int demRight){
        Rational rational1 = new Rational(numLeft, demLeft);
        Rational rational2 = new Rational(numRight, demRight);
        assertTrue("Сравнить дроби не получилось", rational1.less(rational2));
    }

    @Test
    @Parameters({
            "1, 2, 2, 4"
    })
    public void testLessOrEqualTrue(int numLeft, int demLeft, int numRight, int demRight) {
        Rational rational1 = new Rational(numLeft, demLeft);
        Rational rational2 = new Rational(numRight, demRight);
        assertTrue("Сравнить дроби не получилось", rational1.lessOrEqual(rational2));
    }

    @Test
    @Parameters({
            "1, 2, -2, 4"
    })
    public void testLessOrEqualFalse(int numLeft, int demLeft, int numRight, int demRight) {
        Rational rational1 = new Rational(numLeft, demLeft);
        Rational rational2 = new Rational(numRight, demRight);
        assertFalse("Сравнить дроби не получилось", rational1.lessOrEqual(rational2));
    }

    @Test
    @Parameters({
            "5, 10, 1/2",
            "-4, -16, 1/4"
    })
    public void testReduce(int num, int dem, String expectedResult){
        Rational rational = new Rational(num, dem);
        assertEquals("Сократить не получилось", expectedResult,  rational.toString());
    }

    @Test
    @Parameters({
            "-3, 4",
            "3, -4"
    })
    public void testSimplifyMinuses(int num, int dem) {
        Rational rational = new Rational(num, dem);
        assertTrue("Минус должен стоять перед числителем", rational.getNumerator() <= 0);
        assertTrue("Минус должен стоять перед числителем", rational.getDenominator() > 0);
    }
}






