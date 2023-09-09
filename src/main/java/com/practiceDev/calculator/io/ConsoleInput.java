package com.practiceDev.calculator.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Input{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String selectMenu(String s) throws IOException {
        System.out.print(s);
        return br.readLine();
    }

    @Override
    public String input() throws IOException {
        System.out.println();
        return br.readLine();
    }
}
