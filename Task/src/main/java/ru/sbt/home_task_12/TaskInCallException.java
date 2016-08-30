package ru.sbt.home_task_12;

public class TaskInCallException extends RuntimeException {

    public TaskInCallException(String message) {
        super(message);
    }

    public TaskInCallException(Throwable cause) {
        super(cause);
    }

    public TaskInCallException(String message, Throwable cause) {
        super(message, cause);
    }
}