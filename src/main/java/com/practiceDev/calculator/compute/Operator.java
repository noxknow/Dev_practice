package com.practiceDev.calculator.compute;

import java.util.function.BiFunction;

public enum Operator {
    ADD("+", 2, (num1, num2) -> num1 + num2),
    SUBTRACT("-", 2, (num1, num2) -> num1 - num2),
    MULTIPLY("*", 3, (num1, num2) -> num1 * num2),
    DIVIDE("/", 3, (num1, num2) -> num1 / num2);

    private final String operator;
    private final int priority;
    private final BiFunction<Long, Long, Long> expression;

    Operator(String operator, int priority, BiFunction<Long, Long, Long> expression) {
        this.operator = operator;
        this.priority = priority;
        this.expression = expression;
    }
}
