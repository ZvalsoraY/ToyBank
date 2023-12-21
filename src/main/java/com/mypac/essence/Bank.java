package com.mypac.essence;

import java.util.concurrent.atomic.AtomicLong;

public class Bank {
    private AtomicLong balance = new AtomicLong(0);

    /*public Bank(long balance) {
        this.balance = balance;
    }*/

    /*public long getBalance() {
        return balance;
    }*/

    public synchronized void increase(long value) {
        balance.getAndUpdate(b -> b + value);
        System.out.println("Заявка increase выполнена. Bank " + balance);
    }

    public synchronized void decrease(long value) {
        balance.addAndGet(-value);
        System.out.println("Заявка decrease выполнена. Bank " + balance);
    }
}
