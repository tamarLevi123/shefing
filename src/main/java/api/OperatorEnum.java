package api;

import java.util.function.BinaryOperator;

public enum OperatorEnum {
    plus("+", (a, b) -> a + b),
    minus("-", (a, b) -> a - b),
    multiply("*", (a, b) -> a * b),
    divide("/", (a, b) -> a / b);

    private String operatorString;
    private BinaryOperator<Integer> accumulator;

    public String getOperatorString() {
        return operatorString;
    }

    public void setOperatorString(String operatorString) {
        this.operatorString = operatorString;
    }

    public BinaryOperator<Integer> getAccumulator() {
        return accumulator;
    }

    public void setAccumulator(BinaryOperator<Integer> accumulator) {
        this.accumulator = accumulator;
    }

    OperatorEnum(String operatorString, BinaryOperator<Integer> accumulator) {
        this.operatorString = operatorString;
        this.accumulator = accumulator;
    }

    public static OperatorEnum tryValueOf(String name) {
        try {
            return OperatorEnum.valueOf(name);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
