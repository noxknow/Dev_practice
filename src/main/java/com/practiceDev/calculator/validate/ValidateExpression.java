package com.practiceDev.calculator.validate;

public class ValidateExpression implements Validate {

    // 정규식 테스트 할때는 \ 이스케이프 문자가 하나만 있어도 되지만 코드상에서는 2개가 필요하다.
    // - 앞의 \\ 는 -가 범위를 나타낼때 쓰는 0-9 "-" 인지 아니면 문자 그대로 마이너스를 의미하는 "-"인지 알려주기 위해서 필요하다.
    private final String expressionPattern = "[0-9]+(\\s[+\\-*/]\\s[0-9]+)+";
    private final String menuPattern = "[1-3]";

    @Override
    public boolean isValidMenu(String input) {
        return input.matches(menuPattern);
    }

    @Override
    public boolean isValidExpression(String expression) {
        return expression.matches(expressionPattern);
    }
}
