package fr.hetic.domain;

import fr.hetic.infrastructure.OperatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setup() {
        OperatorFactory operatorFactory = new OperatorFactory();
        calculator = new Calculator(operatorFactory);
    }

    @Test
    public void shouldReturnCorrectResultsWhenValidOperationsAreProvided() {
        List<String> results = calculator.processLines(List.of("5 3 +"));

        assertEquals(List.of("8"), results);
    }

    @Test
    public void shouldReturnErrorMessageWhenInvalidFormatIsProvided() {
        List<String> results = calculator.processLines(List.of("5 3"));

        assertEquals(List.of("Error: Operation must be in the format: <operand1> <operand2> <operator>"), results);
    }

    @Test
    public void shouldReturnErrorMessageWhenNonIntegerOperandsAreProvided() {
        List<String> results = calculator.processLines(List.of("5.5 3 +"));

        assertEquals(List.of("Error: Operands must be integers"), results);
    }

    @Test
    public void shouldReturnErrorMessageWhenInvalidOperatorIsProvided() {
        List<String> results = calculator.processLines(List.of("5 3 x"));

        assertEquals(List.of("Error: Operator must be one of: + - * /"), results);
    }

    @Test
    public void shouldReturnErrorMessageWhenDivisionByZeroIsAttempted() {
        List<String> results = calculator.processLines(List.of("5 0 /"));

        assertEquals(List.of("Error: Division by zero is not allowed"), results);
    }
}