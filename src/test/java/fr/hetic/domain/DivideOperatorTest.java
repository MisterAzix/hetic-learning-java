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
        // Given
        int operand1 = 6;
        int operand2 = 3;

        // When
        String result = divideOperator.execute(operand1, operand2);

        // Then
        assertEquals("2.0", result);
    }

    @Test
    public void shouldReturnQuotientWhenPositiveAndNegativeNumbersAreProvided() {
        // Given
        int operand1 = 6;
        int operand2 = -3;

        // When
        String result = divideOperator.execute(operand1, operand2);

        // Then
        assertEquals("-2.0", result);
    }

    @Test
    public void shouldReturnQuotientWhenTwoNegativeNumbersAreProvided() {
        // Given
        int operand1 = -6;
        int operand2 = -3;

        // When
        String result = divideOperator.execute(operand1, operand2);

        // Then
        assertEquals("2.0", result);
    }

    @Test
    public void shouldReturnZeroWhenZeroAndAnyNumberAreProvided() {
        // Given
        int operand1 = 0;
        int operand2 = 5;

        // When
        String result = divideOperator.execute(operand1, operand2);

        // Then
        assertEquals("0.0", result);
    }

    @Test
    public void shouldThrowArithmeticExceptionWhenDivideByZero() {
        assertThrows(ArithmeticException.class, () -> divideOperator.execute(5, 0));
    }
}