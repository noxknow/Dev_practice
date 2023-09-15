package com.practiceDev.calculator.compute;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ComputeOperationTest {

    Compute compute = new ComputeOperation();

    @Test
    void 계산_결과_테스트() {

        //when
        String input = "132 + 2 + 31";

        //given
        List<String> token = compute.convertToToken(input);
        List<String> postfix = compute.convertTokenToPostfix(token);
        long result = compute.calculate(postfix);

        //then
        Assertions.assertEquals(result, 165);
    }
}
