package fr.hetic.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DivideOperatorTest {
    private DivideOperator divideOperator;

    @BeforeEach
    public void setup() {
        divideOperator = new DivideOperator();
    }

    @Test
    public void shouldReturnQuotientWhenTwoPositiveNumbersAreProvided() {
        String result = divideOperator.execute(6, 3);
        assertEquals("2.0", result);
    }

    @Test
    public void shouldReturnQuotientWhenPositiveAndNegativeNumbersAreProvided() {
        String result = divideOperator.execute(6, -3);
        assertEquals("-2.0", result);
    }

    @Test
    public void shouldReturnQuotientWhenTwoNegativeNumbersAreProvided() {
        String result = divideOperator.execute(-6, -3);
        assertEquals("2.0", result);
    }

    @Test
    public void shouldReturnZeroWhenZeroAndAnyNumberAreProvided() {
        String result = divideOperator.execute(0, 5);
        assertEquals("0.0", result);
    }

    @Test
    public void shouldThrowArithmeticExceptionWhenDivideByZero() {
        assertThrows(ArithmeticException.class, () -> divideOperator.execute(5, 0));
    }
}