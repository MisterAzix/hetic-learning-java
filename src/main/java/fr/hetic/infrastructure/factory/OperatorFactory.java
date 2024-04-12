package fr.hetic.infrastructure.factory;

import fr.hetic.domain.*;
import fr.hetic.domain.exception.OperatorException;
import fr.hetic.domain.type.OperatorType;

import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {
    private final Map<String, Operator> operators;

    public OperatorFactory() {
        operators = new HashMap<>();
        operators.put(OperatorType.ADD.getSymbol(), new AddOperator());
        operators.put(OperatorType.SUBTRACT.getSymbol(), new SubstractOperator());
        operators.put(OperatorType.MULTIPLY.getSymbol(), new MultiplyOperator());
        operators.put(OperatorType.DIVIDE.getSymbol(), new DivideOperator());
    }

    public Operator getOperator(String operator) {
        Operator op = operators.get(operator);
        if (op == null) {
            throw new OperatorException();
        }
        return op;
    }
}