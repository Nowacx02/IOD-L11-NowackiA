package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach//testy przestałyby działać gdyż obiekt typu Calculator nie jest statyczny
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void testAdd(){
        assertEquals(9, calculator.add(2,7));
        assertEquals(17, calculator.add(10,7));
    }

    @Test
    public void testMultiply(){
        assertEquals(8, calculator.multiply(2, 4));
        assertEquals(21, calculator.multiply(7,3));
    }

    @Test
    public void testAddPositiveNumbers(){
        assertThrows(IllegalArgumentException.class, () -> {calculator.addPositiveNumbers(-2, -8);});
    }
}