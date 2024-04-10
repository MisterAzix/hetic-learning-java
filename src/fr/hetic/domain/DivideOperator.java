package fr.hetic.domain;

import fr.hetic.domain.Operator;

public class DivideOperator implements Operator {
    public String execute(int a, int b) {
        return String.valueOf((double) a / b);
    }
}
