package com.practiceDev.calculator.compute;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ComputeOperation implements Compute {

    private final String pattern = "\\d+";

    @Override
    public List<String> convertTokenToPostfix(List<String> tokens) {

        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.matches(pattern)) {
                postfix.add(token);
            } else {
                while (!stack.isEmpty() && isLowerThanStack(token, stack.peek())) {
                    postfix.add(stack.pop());
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }

        return postfix;
    }

    @Override
    public long calculate(List<String> postfix) {

        Stack<Long> stack = new Stack<>();
        for (String token : postfix) {
            if (token.matches(pattern)) {
                stack.push(Long.parseLong(token));
            } else {
                long firstNumber = stack.pop();
                long secondNumber = stack.pop();
                Operator operator = Operator.getOperator(token);

                stack.push(operator.calculate(firstNumber, secondNumber));
            }
        }

        return stack.pop();
    }

    @Override
    public long compute(String input) {

        List<String> tokens = convertToToken(input);
        List<String> postfix = convertTokenToPostfix(tokens);
        long result = calculate(postfix);

        return result;
    }

    private boolean isLowerThanStack(String tmpOp, String stackOp) {

        Operator tmpOperator = Operator.getOperator(tmpOp); // 열거형 상수는 직접 인스턴스화하지 않고 정적 팩토리 메서드를 사용하여 얻을 수 있다.
        Operator stackOperator = Operator.getOperator(stackOp);

        return stackOperator.getPriority() >= tmpOperator.getPriority();
    }
}
