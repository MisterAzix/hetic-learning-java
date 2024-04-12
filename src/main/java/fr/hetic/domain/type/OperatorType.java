package fr.hetic.domain.type;

public enum OperatorType {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public static OperatorType fromSymbol(String symbol) {
        for (OperatorType operator : values()) {
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("Unknown operator symbol: " + symbol);
    }

    public String getSymbol() {
        return symbol;
    }
}