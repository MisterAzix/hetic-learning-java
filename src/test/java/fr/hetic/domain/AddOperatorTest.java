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
        String result = addOperator.execute(5, 3);
        assertEquals("8", result);
    }

    @Test
    public void shouldReturnSumWhenPositiveAndNegativeNumbersAreProvided() {
        String result = addOperator.execute(5, -3);
        assertEquals("2", result);
    }

    @Test
    public void shouldReturnSumWhenTwoNegativeNumbersAreProvided() {
        String result = addOperator.execute(-5, -3);
        assertEquals("-8", result);
    }
}