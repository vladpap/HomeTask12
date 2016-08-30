package ru.sbt.home_task_12.example;

import ru.sbt.home_task_12.Task;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        List<Task<Integer>> taskList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            taskList.add(new Task<>(new Factorial(5 + i)));
        }
        for (int i = 0; i < 2; i++) {
            for (Task<Integer> integerTask : taskList) {
                System.out.println("Result = " + integerTask.get());
            }
        }

        System.out.printf("Time: %.3f", (double) ((System.currentTimeMillis() - startTime) / 1_000));
    }
}