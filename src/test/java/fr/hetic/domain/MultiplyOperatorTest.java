package fr.hetic.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplyOperatorTest {
    private MultiplyOperator multiplyOperator;

    @BeforeEach
    public void setup() {
        multiplyOperator = new MultiplyOperator();
    }

    @Test
    public void shouldReturnProductWhenTwoPositiveNumbersAreProvided() {
        // Given
        int operand1 = 5;
        int operand2 = 3;

        // When
        String result = multiplyOperator.execute(operand1, operand2);

        // Then
        assertEquals("15", result);
    }

    @Test
    public void shouldReturnProductWhenPositiveAndNegativeNumbersAreProvided() {
        // Given
        int operand1 = 5;
        int operand2 = -3;

        // When
        String result = multiplyOperator.execute(operand1, operand2);

        // Then
        assertEquals("-15", result);
    }

    @Test
    public void shouldReturnProductWhenTwoNegativeNumbersAreProvided() {
        // Given
        int operand1 = -5;
        int operand2 = -3;

        // When
        String result = multiplyOperator.execute(operand1, operand2);

        // Then
        assertEquals("15", result);
    }

    @Test
    public void shouldReturnZeroWhenZeroAndAnyNumberAreProvided() {
        // Given
        int operand1 = 0;
        int operand2 = 5;

        // When
        String result = multiplyOperator.execute(operand1, operand2);

        // Then
        assertEquals("0", result);
    }
}