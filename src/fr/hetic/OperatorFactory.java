package fr.hetic;

public class OperatorFactory {
    public static Operator getOperator(String operator) {
        switch (operator) {
            case "+":
                return new AddOperator();
            case "-":
                return new SubstractOperator();
            case "*":
                return new MultiplyOperator();
            case "/":
                return new DivideOperator();
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
