package com.practiceDev.calculator.io;

import com.practiceDev.calculator.repository.Repository;

public class ConsoleOutput implements Output {

    @Override
    public void printMenu(String menu) {
        System.out.println(menu);
        System.out.println();
    }

    @Override
    public void printCalculateResult(long result) {
        System.out.println(result);
        System.out.println();
    }

    @Override
    public void printSavedResults(Repository repository) {
        repository.showSavedResults();
    }
}
