package fr.hetic;

public class DivideOperator implements Operator {
    public String execute(int a, int b) {
        return String.valueOf((double) a / b);
    }
}
