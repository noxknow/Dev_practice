package com.practiceDev.calculator.repository;

import java.util.ArrayList;
import java.util.List;

public class ArrayListRepository implements Repository {

    private final List<String> results = new ArrayList<>();

    @Override
    public void saveResult(String input, long output) {
        String result = input + " = " + output;
        results.add(result);
    }

    @Override
    public void showSavedResults() {
        System.out.println();
        results.stream().forEach(System.out::println); // System.out 객체의 println 메서드를 참조
        System.out.println();
    }
}
