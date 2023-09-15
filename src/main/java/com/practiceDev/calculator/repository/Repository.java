package com.practiceDev.calculator.repository;

public interface Repository {

    void saveResult(String input, long output);
    void showSavedResults();
}
