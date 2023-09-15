package com.practiceDev.calculator.io;

import com.practiceDev.calculator.repository.Repository;

public interface Output {

    void printMenu(String menu);
    void printCalculateResult(long result);
    void printSavedResults(Repository repository);
}
