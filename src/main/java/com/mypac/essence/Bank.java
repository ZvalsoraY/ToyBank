package com.mypac.essence;

public class Bank {
    private long balance;

    public Bank(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void increase(long value) {
        balance += value;
    }

    public void decrease(long value) {
        balance -= value;
    }
}
