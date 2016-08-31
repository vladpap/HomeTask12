package ru.sbt.home_task_12.example;

import java.util.concurrent.Callable;

public class Factorial implements Callable<Long> {
    int number;

    public Factorial(int v) {
        number = v;
    }

    @Override
    public Long call() throws Exception {
        return getFactorial(number);
    }

    private Long getFactorial(int n) throws InterruptedException {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(250);
        return fact;
    }
}