package fr.hetic.infrastructure;

import fr.hetic.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperatorFactoryTest {
    private OperatorFactory operatorFactory;

    @BeforeEach
    public void setup() {
        operatorFactory = new OperatorFactory();
    }

    @Test
    public void shouldReturnAddOperatorWhenAddSymbolIsProvided() {
        Operator operator = operatorFactory.getOperator("+");
        assertTrue(operator instanceof AddOperator);
    }

    @Test
    public void shouldReturnSubtractOperatorWhenSubtractSymbolIsProvided() {
        Operator operator = operatorFactory.getOperator("-");
        assertTrue(operator instanceof SubstractOperator);
    }

    @Test
    public void shouldReturnMultiplyOperatorWhenMultiplySymbolIsProvided() {
        Operator operator = operatorFactory.getOperator("*");
        assertTrue(operator instanceof MultiplyOperator);
    }

    @Test
    public void shouldReturnDivideOperatorWhenDivideSymbolIsProvided() {
        Operator operator = operatorFactory.getOperator("/");
        assertTrue(operator instanceof DivideOperator);
    }

    @Test
    public void shouldThrowOperatorExceptionWhenInvalidSymbolIsProvided() {
        assertThrows(OperatorException.class, () -> operatorFactory.getOperator("%"));
    }
}