package com.practiceDev.calculator.io;

public class ConsoleOutput implements Output {

    @Override
    public void printMenu(String menu) {
        System.out.println(menu);
        System.out.println();
    }

    @Override
    public void CalculateResult(long result) {
        System.out.println(result);
        System.out.println();
    }
}
