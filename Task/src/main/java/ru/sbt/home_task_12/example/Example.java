package ru.sbt.home_task_12.example;

import ru.sbt.home_task_12.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Example {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        List<Task<Long>> taskList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            taskList.add(new Task<>(new Factorial(5 + i)));
        }
        for (Task<Long> longTask : taskList) {
//            longTask.run();
        }

        for (int i = 0; i < 2; i++) {
            for (Task<Long> integerTask : taskList) {
                System.out.println("Result = " + integerTask.get());
            }
        }
        Task.shutdown();

    }
}