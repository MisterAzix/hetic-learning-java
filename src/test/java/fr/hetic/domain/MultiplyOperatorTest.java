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
        String result = multiplyOperator.execute(5, 3);
        assertEquals("15", result);
    }

    @Test
    public void shouldReturnProductWhenPositiveAndNegativeNumbersAreProvided() {
        String result = multiplyOperator.execute(5, -3);
        assertEquals("-15", result);
    }

    @Test
    public void shouldReturnProductWhenTwoNegativeNumbersAreProvided() {
        String result = multiplyOperator.execute(-5, -3);
        assertEquals("15", result);
    }

    @Test
    public void shouldReturnZeroWhenZeroAndAnyNumberAreProvided() {
        String result = multiplyOperator.execute(0, 5);
        assertEquals("0", result);
    }
}