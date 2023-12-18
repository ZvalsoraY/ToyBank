package com.mypac.essence;

public class Bank {
    private long balance;

    public Bank(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public synchronized void increase(long value) {
        balance += value;
        System.out.println("Заявка increase выполнена. Bank " + balance);
    }

    public synchronized void decrease(long value) {
        balance -= value;
        System.out.println("Заявка decrease выполнена. Bank " + balance);
    }
}
