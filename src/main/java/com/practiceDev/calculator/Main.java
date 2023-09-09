package com.practiceDev.calculator;

import com.practiceDev.calculator.compute.Compute;
import com.practiceDev.calculator.compute.ComputeOperation;
import com.practiceDev.calculator.io.ConsoleInput;
import com.practiceDev.calculator.io.ConsoleOutput;
import com.practiceDev.calculator.io.Input;
import com.practiceDev.calculator.io.Output;

public class Main {

    public static void main(String[] args) {

        Input consoleInput = new ConsoleInput();
        Output consoleOutput = new ConsoleOutput();
        Compute computeOperation = new ComputeOperation();

        new Calculator(consoleInput, consoleOutput, computeOperation).run(); // DI 객체 간의 결합도를 낮추고 테스트 및 확장성을 향상
    }
}
