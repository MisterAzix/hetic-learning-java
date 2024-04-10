package fr.hetic.domain;

public class AddOperator implements Operator {
    public String execute(int a, int b) {
        return String.valueOf(a + b);
    }
}
