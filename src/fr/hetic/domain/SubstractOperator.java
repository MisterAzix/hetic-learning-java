package fr.hetic.domain;

public class SubstractOperator implements Operator {
    public String execute(int a, int b) {
        return String.valueOf(a - b);
    }
}
