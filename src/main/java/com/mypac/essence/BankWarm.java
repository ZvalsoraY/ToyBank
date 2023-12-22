package com.mypac.essence;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class BankWarm implements Callable<Void> {
    private int timeProcess;
    private int changeSum;
    private Bank bank;

    public BankWarm(int timeProcess, int changeSum, Bank bank) {
        this.timeProcess = timeProcess;
        this.changeSum = changeSum;
        this.bank = bank;
    }

    @Override
    public Void call() throws Exception {
        Thread.sleep(timeProcess);
        bank.increase(changeSum);
        System.out.println("Warm bank with delay: " + timeProcess  );
        return null;
    }
}
