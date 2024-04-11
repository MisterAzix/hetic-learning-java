package fr.hetic.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubstractOperatorTest {
    private SubstractOperator substractOperator;

    @BeforeEach
    public void setup() {
        substractOperator = new SubstractOperator();
    }

    @Test
    public void shouldReturnDifferenceWhenTwoPositiveNumbersAreProvided() {
        // Given
        int operand1 = 5;
        int operand2 = 3;

        // When
        String result = substractOperator.execute(operand1, operand2);

        // Then
        assertEquals("2", result);
    }

    @Test
    public void shouldReturnDifferenceWhenPositiveAndNegativeNumbersAreProvided() {
        // Given
        int operand1 = 5;
        int operand2 = -3;

        // When
        String result = substractOperator.execute(operand1, operand2);

        // Then
        assertEquals("8", result);
    }

    @Test
    public void shouldReturnDifferenceWhenTwoNegativeNumbersAreProvided() {
        // Given
        int operand1 = -5;
        int operand2 = -3;

        // When
        String result = substractOperator.execute(operand1, operand2);

        // Then
        assertEquals("-2", result);
    }
}