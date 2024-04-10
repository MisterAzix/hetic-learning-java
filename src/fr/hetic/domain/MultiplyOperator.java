package fr.hetic.domain;

import fr.hetic.domain.Operator;

public class MultiplyOperator implements Operator {
    public String execute(int a, int b) {
        return String.valueOf(a * b);
    }
}
