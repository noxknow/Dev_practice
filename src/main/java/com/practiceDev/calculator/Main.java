package com.practiceDev.calculator;

import com.practiceDev.calculator.compute.Compute;
import com.practiceDev.calculator.compute.ComputeOperation;
import com.practiceDev.calculator.io.ConsoleInput;
import com.practiceDev.calculator.io.ConsoleOutput;
import com.practiceDev.calculator.io.Input;
import com.practiceDev.calculator.io.Output;
import com.practiceDev.calculator.repository.ArrayListRepository;
import com.practiceDev.calculator.repository.Repository;
import com.practiceDev.calculator.validate.Validate;
import com.practiceDev.calculator.validate.ValidateExpression;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Input consoleInput = new ConsoleInput();
        Output consoleOutput = new ConsoleOutput();
        Validate validateExpression = new ValidateExpression();
        Compute computeOperation = new ComputeOperation();
        Repository arrayListRepository = new ArrayListRepository();

        new Calculator(consoleInput, consoleOutput, validateExpression, computeOperation, arrayListRepository).run(); // DI 객체 간의 결합도를 낮추고 테스트 및 확장성을 향상
    }
}
