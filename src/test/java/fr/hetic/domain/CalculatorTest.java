package fr.hetic.domain;

import fr.hetic.domain.repository.FileRepository;
import fr.hetic.domain.type.OperatorType;
import fr.hetic.domain.valueObject.InputLineValueObject;
import fr.hetic.domain.valueObject.OutputLineValueObject;
import fr.hetic.infrastructure.adapter.LocalFileRepositoryAdapter;
import fr.hetic.infrastructure.factory.OperatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setup() {
        OperatorFactory operatorFactory = new OperatorFactory();
        FileRepository fileRepositoryMock = mock(LocalFileRepositoryAdapter.class);

        calculator = new Calculator(operatorFactory, fileRepositoryMock);
    }

    @Test
    public void shouldReturnCorrectResultsWhenValidOperationsAreProvided() {
        // Given
        List<InputLineValueObject> lines = List.of(
                new InputLineValueObject(5, 3, OperatorType.ADD, 1),
                new InputLineValueObject(5, 3, OperatorType.SUBTRACT, 2),
                new InputLineValueObject(5, 3, OperatorType.MULTIPLY, 3),
                new InputLineValueObject(6, 3, OperatorType.DIVIDE, 4)
        );

        // When
        List<OutputLineValueObject> results = calculator.processLines(lines);

        // Then
        assertEquals(List.of(
                new OutputLineValueObject("8"),
                new OutputLineValueObject("2"),
                new OutputLineValueObject("15"),
                new OutputLineValueObject("2.0")
        ), results);
    }

    @Test
    public void shouldReturnErrorMessageWhenDivisionByZeroIsAttempted() {
        // Given
        List<InputLineValueObject> lines = List.of(new InputLineValueObject(5, 0, OperatorType.DIVIDE, 1));

        // When
        List<OutputLineValueObject> results = calculator.processLines(lines);

        // Then
        assertEquals(List.of(new OutputLineValueObject("")), results);
    }
}