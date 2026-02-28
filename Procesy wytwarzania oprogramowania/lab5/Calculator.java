package org.example.calculations;

public class Calculator {

    public int multiply(int a, int b) {
        return a * b;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int divide(int a, int b) {
        return a / b;
    }
}

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Multiplication of calculator")
    void testMultiply() {
        assertEquals(10, calculator.multiply(2, 5),
                "Multiplication should work");
    }

    @RepeatedTest(10)
    @DisplayName("Ensure correct multiplication by zero")
    void testMultiplicationByZero() {
        assertEquals(0, calculator.multiply(0, 10),
                "Multiplication by zero should be zero");
        assertEquals(0, calculator.multiply(1, 0),
                "Multiplication by zero should be zero");
    }

    @RepeatedTest(10)
    @DisplayName("Ensure correct multiplication by one")
    void testMultiplicationByOne() {
        assertEquals(0, calculator.multiply(1, 10),
                "Multiplication ten by one should be ten");
        assertEquals(0, calculator.multiply(1, 5),
                "Multiplication five by one should be five");
    }

    // Addition

    @Test
    @DisplayName("Addition of calculator")
    void testAddition() {
        assertEquals(7, calculator.add(3, 4),
                "Addition should work");
    }

    @RepeatedTest(10)
    @DisplayName("Ensure addition with zero works correctly")
    void testAdditionWithZero() {
        assertEquals(5, calculator.add(8, 0), "Addition eight plus zero should be five");
        assertEquals(5, calculator.add(0, 8), "Addition 0 plus eight should be six");
    }

    // Substraction

    @Test
    @DisplayName("Subtraction of calculator")
    void testSubtraction() {
        assertEquals(1, calculator.subtract(5, 4),
                "Subtraction should work");
    }

    @RepeatedTest(10)
    @DisplayName("Ensure subtraction with zero works correctly")
    void testSubtractionWithZero() {
        assertEquals(5, calculator.subtract(5, 0), "Substraction five minus zero should be zero");
        assertEquals(-5, calculator.subtract(0, 5),"Substraction zero minus five should be zero");
    }

    // Division

    @Test
    @DisplayName("Division of calculator")
    void testDivision() {
        assertEquals(5, calculator.divide(10, 2),
                "Division should work");
    }

    @Test
    @DisplayName("Division by zero should throw ArithmeticException")
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class,
                () -> calculator.divide(5, 0),
                "Division by zero should throw exception");
    }

    @RepeatedTest(5)
    @DisplayName("Ensure division by one works")
    void testDivisionByOne() {
        assertEquals(10, calculator.divide(10, 1), "Division ten by one should be 10");
    }
}
