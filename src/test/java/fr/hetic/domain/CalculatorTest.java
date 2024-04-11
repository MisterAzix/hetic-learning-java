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
        // Given
        List<String> lines = List.of("5 3 +", "5 3 -", "5 3 *", "6 3 /");

        // When
        List<String> results = calculator.processLines(lines);

        // Then
        assertEquals(List.of("8", "2", "15", "2.0"), results);
    }

    @Test
    public void shouldReturnErrorMessageWhenInvalidFormatIsProvided() {
        // Given
        List<String> lines = List.of("5 3");

        // When
        List<String> results = calculator.processLines(lines);

        // Then
        assertEquals(List.of("Error: Operation must be in the format: <operand1> <operand2> <operator>"), results);
    }

    @Test
    public void shouldReturnErrorMessageWhenNonIntegerOperandsAreProvided() {
        // Given
        List<String> lines = List.of("5.5 3 +");

        // When
        List<String> results = calculator.processLines(lines);

        // Then
        assertEquals(List.of("Error: Operands must be integers"), results);
    }

    @Test
    public void shouldReturnErrorMessageWhenInvalidOperatorIsProvided() {
        // Given
        List<String> lines = List.of("5 3 x");

        // When
        List<String> results = calculator.processLines(lines);

        // Then
        assertEquals(List.of("Error: Operator must be one of: + - * /"), results);
    }

    @Test
    public void shouldReturnErrorMessageWhenDivisionByZeroIsAttempted() {
        // Given
        List<String> lines = List.of("5 0 /");

        // When
        List<String> results = calculator.processLines(lines);

        // Then
        assertEquals(List.of("Error: Division by zero is not allowed"), results);
    }
}