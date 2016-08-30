package ru.sbt.home_task_12;

import java.util.concurrent.Callable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Task<T> {
    private final Callable<? extends T> callable;
    private static Semaphore sem = new Semaphore(1, true);
    private Exception exception;
    private final Map<Object, T> cacheMap;
    private static final Object LOCK = new Object();
    private volatile boolean isException;


    public Task(Callable<? extends T> callable) {
        this.callable = callable;
        this.cacheMap = new HashMap<>();
        this.isException = false;
        this.exception = null;
    }

    public T get() throws TaskInCallException {

        if (isException) throw new TaskInCallException(exception);

        try {
            sem.acquire();
        } catch (InterruptedException e) {
            throw new TaskInCallException(e);
        }

        synchronized (LOCK) {
            if (cacheMap.containsKey(callable)) {
                return cacheMap.get(callable);
            }
            try {
                T result = this.callable.call();
                cacheMap.put(this.callable, result);
                sem.release();
                return result;
            } catch (Exception e) {
                this.isException = true;
                this.exception = e;
                throw new TaskInCallException(e);
            } finally {
                sem.release();
            }
        }

    }
}