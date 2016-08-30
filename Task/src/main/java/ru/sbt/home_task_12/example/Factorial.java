package ru.sbt.home_task_12.example;

import java.util.concurrent.Callable;

public class Factorial implements Callable<Integer> {
    int stop;

    public Factorial(int v) {
        stop = v;
    }

    @Override
    public Integer call() throws Exception {
        int fact = 1;
        for (int i = 2; i <= stop; i++) {
            fact *= i;
        }
//        System.out.println("Factorial " + stop + " = " + fact);
        Thread.sleep(250);
        return fact;
    }
}