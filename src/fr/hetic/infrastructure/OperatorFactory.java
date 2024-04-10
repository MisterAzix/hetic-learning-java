package fr.hetic.infrastructure;

import fr.hetic.domain.*;
import fr.hetic.domain.AddOperator;
import fr.hetic.domain.DivideOperator;
import fr.hetic.domain.MultiplyOperator;
import fr.hetic.domain.SubstractOperator;

import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {
    private final Map<String, Operator> operators;

    public OperatorFactory() {
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
