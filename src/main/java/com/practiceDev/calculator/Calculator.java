package com.practiceDev.calculator;

import com.practiceDev.calculator.compute.Compute;
import com.practiceDev.calculator.io.Input;
import com.practiceDev.calculator.io.Output;

import java.io.IOException;

public class Calculator {

    private Input input;
    private Output output;
    private Compute compute;

    // 생성자 호출 이후 필드가 초기화되며 전달된 값을 저장
    public Calculator (Input input, Output output, Compute compute) {
        this.input = input;
        this.output = output;
        this.compute = compute;
    }

    public void run() {

    }

    public void printMenu() {
        output.printMenu("1. 조회\n2. 계산\n3. 종료");
    }

    private String getInput() throws IOException {
        return input.selectMenu("선택 : ");
    }

}
