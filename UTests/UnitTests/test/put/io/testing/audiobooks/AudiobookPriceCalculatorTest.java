package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    private AudiobookPriceCalculator calc;
    @BeforeEach
    public void setUp(){
        calc = new AudiobookPriceCalculator();
    }
    @Test
    public void test1(){
        assertEquals(0.0, calc.calculate(new Customer("test1", Customer.LoyaltyLevel.GOLD, true), new Audiobook("test1", 100)));
    }
    @Test
    public void test2(){
        assertEquals(0.9 * 100, calc.calculate(new Customer("test2", Customer.LoyaltyLevel.SILVER, false), new Audiobook("test2", 100)));
    }
    @Test
    public void test3(){
        assertEquals(0.8 * 100, calc.calculate(new Customer("test3", Customer.LoyaltyLevel.GOLD, false), new Audiobook("test3", 100)));
    }
    @Test
    public void test4(){
        assertEquals(100, calc.calculate(new Customer("test4", Customer.LoyaltyLevel.STANDARD, false), new Audiobook("test4", 100)));
    }
}