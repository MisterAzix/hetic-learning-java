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
        String result = substractOperator.execute(5, 3);
        assertEquals("2", result);
    }

    @Test
    public void shouldReturnDifferenceWhenPositiveAndNegativeNumbersAreProvided() {
        String result = substractOperator.execute(5, -3);
        assertEquals("8", result);
    }

    @Test
    public void shouldReturnDifferenceWhenTwoNegativeNumbersAreProvided() {
        String result = substractOperator.execute(-5, -3);
        assertEquals("-2", result);
    }
}