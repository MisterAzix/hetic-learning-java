package fr.hetic.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddOperatorTest {
    private AddOperator addOperator;

    @BeforeEach
    public void setup() {
        addOperator = new AddOperator();
    }

    @Test
    public void shouldReturnSumWhenTwoPositiveNumbersAreProvided() {
        // Given
        int operand1 = 5;
        int operand2 = 3;

        // When
        String result = addOperator.execute(operand1, operand2);

        // Then
        assertEquals("8", result);
    }

    @Test
    public void shouldReturnSumWhenPositiveAndNegativeNumbersAreProvided() {
        // Given
        int operand1 = 5;
        int operand2 = -3;

        // When
        String result = addOperator.execute(operand1, operand2);

        // Then
        assertEquals("2", result);
    }

    @Test
    public void shouldReturnSumWhenTwoNegativeNumbersAreProvided() {
        // Given
        int operand1 = -5;
        int operand2 = -3;

        // When
        String result = addOperator.execute(operand1, operand2);

        // Then
        assertEquals("-8", result);
    }
}