package com.mypac.essence;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private AtomicLong balance = new AtomicLong(0);
    private Lock lock = new ReentrantLock();

    public void increase(long value) {
        lock.lock();
        balance.getAndUpdate(b -> b + value);
        lock.unlock();
        System.out.println("Заявка increase выполнена. Bank " + balance);

    }

    public void decrease(long value) {
        lock.lock();
        balance.addAndGet(-value);
        lock.unlock();
        System.out.println("Заявка decrease выполнена. Bank " + balance);

    }
}
