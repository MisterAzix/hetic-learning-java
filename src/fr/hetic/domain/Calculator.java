package fr.hetic.domain;

import fr.hetic.infrastructure.OperatorFactory;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final OperatorFactory operatorFactory;

    public Calculator(OperatorFactory operatorFactory) {
        this.operatorFactory = operatorFactory;
    }

    public List<String> processLines(List<String> lines) {
        List<String> results = new ArrayList<>();

        for (String line : lines) {
            try {
                results.add(processLine(line));
            } catch (IllegalArgumentException e) {
                results.add("Invalid input");
            }
        }

        return results;
    }

    private String processLine(String line) {
        String[] tokens = line.split(" ");
        validateInput(tokens);

        int operand1 = Integer.parseInt(tokens[0]);
        int operand2 = Integer.parseInt(tokens[1]);
        String operatorSymbol = tokens[2];

        Operator operator = operatorFactory.getOperator(operatorSymbol);
        return operator.execute(operand1, operand2);
    }

    private void validateInput(String[] operandsAndOperator) {
        if (operandsAndOperator.length != 3) {
            throw new IllegalArgumentException("Invalid input");
        }
    }
}