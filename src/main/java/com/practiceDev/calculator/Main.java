package com.practiceDev.calculator;

import com.practiceDev.calculator.io.ConsoleInput;
import com.practiceDev.calculator.io.ConsoleOutput;
import com.practiceDev.calculator.io.Input;
import com.practiceDev.calculator.io.Output;

public class Main {

    public static void main(String[] args) {

        Input consoleInput = new ConsoleInput();
        Output consoleOutput = new ConsoleOutput();

        new Calculator(consoleInput, consoleOutput).run();
    }
}
