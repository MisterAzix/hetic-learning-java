package fr.hetic;

import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {
    private final Map<String, Operator> operators;

    OperatorFactory() {
        operators = new HashMap<>();
        operators.put("+", new AddOperator());
        operators.put("-", new SubstractOperator());
        operators.put("*", new MultiplyOperator());
        operators.put("/", new DivideOperator());
    }

    public Operator getOperator(String operator) {
        Operator op = operators.get(operator);
        if (op == null) {
            throw new IllegalArgumentException("Invalid operator");
        }
        return op;
    }
}
