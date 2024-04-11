package fr.hetic.domain;

public class DivideOperator implements Operator {
    public String execute(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return String.valueOf((double) a / b);
    }
}
