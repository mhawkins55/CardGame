package phase2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LargeNumberTest {

    @Test
    public void testAddition() {
        // Test addition of two large numbers
        LargeNumber num1 = new LargeNumber(1234567890);
        LargeNumber num2 = new LargeNumber(9876543210);
        num1.add(num2);
        // Verify the result of addition
        assertEquals("Result of addition is incorrect", "11111111100", num1.toString());
    }

    @Test
    public void testSubtraction() {
        // Test subtraction of two large numbers
        LargeNumber num1 = new LargeNumber(9876543210);
        LargeNumber num2 = new LargeNumber(1234567890);
        num1.subtract(num2);
        // Verify the result of subtraction
        assertEquals("Result of subtraction is incorrect", "8641975320", num1.toString());
    }

    @Test
    public void testMultiplication() {
        // Test multiplication of two large numbers
        LargeNumber num1 = new LargeNumber(1234567890);
        LargeNumber num2 = new LargeNumber(9876543210);
        num1.multiply(num2);
        // Verify the result of multiplication
        assertEquals("Result of multiplication is incorrect", "12193263111263526900", num1.toString());
    }

    @Test
    public void testDivision() {
        // Test division of two large numbers
        LargeNumber num1 = new LargeNumber(1234567890);
        LargeNumber num2 = new LargeNumber(987654321);
        num1.divide(num2);
        // Verify the result of division
        assertEquals("Result of division is incorrect", "1", num1.toString());
    }

    @Test
    public void testPercent() {
        // Test calculation of percentage
        LargeNumber num1 = new LargeNumber(500);
        LargeNumber num2 = new LargeNumber(50);
        num1.percent(num2);
        // Verify the result of percentage calculation
        assertEquals("Result of percent calculation is incorrect", "10", num1.toString());
    }

    @Test
    public void testPower() {
        // Test exponentiation of a large number
        LargeNumber num1 = new LargeNumber(10);
        LargeNumber num2 = new LargeNumber(3);
        num1.power(num2);
        // Verify the result of exponentiation
        assertEquals("Result of power calculation is incorrect", "1000", num1.toString());
    }
}
